package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.trading.RunesManager;
import game.utils.RandomNumberGenerator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class QuickstepAttackAction extends Action {
    private Actor target;
    /**
     * The direction of incoming attack.
     */
    private String direction;

    /**
     * Random number generator
     */
    private Random rand = new Random();
    private final Menu menu = new Menu();

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;
    RunesManager runesManager = RunesManager.getInstance();

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     */
    public QuickstepAttackAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }
    @Override
    public String execute(Actor actor, GameMap map) {

        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }
        int damage = weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);
        if (!target.isConscious()) {
            result += new DeathAction(actor).execute(target, map);
            if (actor.getDisplayChar() == '@' && target.getDisplayChar() != '@'){
                int numOfRunes = runesManager.transferRunes(target, actor);
                String string = target + " drops " + numOfRunes + " runes";
                result += System.lineSeparator() + string;
                return result;
            }

        }

        //Move the actor to a free location
        Location actorLocation = map.locationOf(actor);
        int xLocation = actorLocation.x();
        int yLocation = actorLocation.y();

        //Array list to hold free locations
        ArrayList<Location> freeLocations = new ArrayList<>();

        //Now we go through and check which locations around the player are free
        for(int x = xLocation - 1; x <= xLocation + 1; x++){
            for(int y = yLocation - 1; y <= yLocation + 1; y++){
                Location tempLocation = new Location(map, x, y);
                if(map.isAnActorAt(tempLocation)){
                    freeLocations.add(tempLocation);
                }
            }
        }

        //Only randomly select if the array is not empty
        if (freeLocations.isEmpty()){
            result += "\n Player did not move as there were no free spaces to quickstep.";
        }
        else{
            //Randomly generate an index from our list
            int randNum = RandomNumberGenerator.getRandomInt(0, freeLocations.size()-1);
            //Get our random location
            Location newLocation = freeLocations.get(randNum);
            //Move the actor there
            map.moveActor(actor, newLocation);
            result += "\n" + actor.toString() + " moves to " + "(" + newLocation.x() + "," + newLocation.y() + ")";
        }

        return result;
    }

    public void getMenu(Actor actor, GameMap map){
        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()) {
                Location destination = exit.getDestination();
//                actions.add(destination.getMoveAction(actor, exit.getName(), exit.getHotKey()));
            }


    }

    /**
     * Describes which target the actor is attacking with which weapon
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses QuickStep on " + target + " with " + weapon;
    }
}
