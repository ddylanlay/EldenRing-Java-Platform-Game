package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enemies.Enemies;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;

/**
 * An action that enables actors to slam in a 8 unit ring around themselves dealing damage equal and accuracy equal
 * to their intrinsic weapon
 * @Created Jamie Tran
 */
public class SlamAttackAction extends Action {
    private ArrayList<Actor> actorInRange = new ArrayList<>();
    private Actor actor;

    /**
     * Constructor
     * @param actor
     */
    public SlamAttackAction(Actor actor){
        this.actor = actor;

    }

    /**
     * A method that executes the action.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string returning the results of the slam.
     */
    public String execute(Actor actor, GameMap map) {
        Weapon weapon = actor.getIntrinsicWeapon();
        scanAround(actor, map);
        String result = "";
        for(Actor target: actorInRange){
            if(RandomNumberGenerator.getRandomInt(100)<=weapon.chanceToHit()){

                target.hurt(weapon.damage());
                result += (target + " is slammed massively for " + weapon.damage() + " damage.");
                result += System.lineSeparator();
                if(actor.isConscious() == false){
                    map.removeActor(target);
                    result += System.lineSeparator() + (target + " has been killed.");

                }
            }
        }

        actorInRange.clear();
        return result;
    }

    /**
     * A method that scans around the actor.
     * @param actor The actor conducting the action
     * @param map The map the actor is located on
     */
    public void scanAround(Actor actor, GameMap map){
        Location actorLocation = map.locationOf(actor);
        int xLocation = actorLocation.x();
        int yLocation = actorLocation.y();

        for(int x = xLocation - 1; x <= xLocation + 1; x++){
            for(int y = yLocation - 1; y <= yLocation + 1; y++){
                Location tempLocation = new Location(map, x, y);
                if(map.isAnActorAt(tempLocation) && map.getActorAt(tempLocation) != actor){
                    actorInRange.add(map.getActorAt(tempLocation));

                }
            }
        }
    }

    /**
     * A string describing the action on menu.
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Slam Attack";
    }
}

