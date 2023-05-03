package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.ResetManager;
import game.Resettable;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.Status;
import game.actionsgame.AttackAction;
import game.actionsgame.AttackActionIntrinsic;
import game.behaviours.*;
import game.trading.RunesManager;
import game.utils.RandomNumberGenerator;
import game.weaponabilities.SlamAttack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Giant Crab Enemy.
 *
 * Created by:
 * @author Jamie Tran
 *
 * Modified by:
 * @author Arosh Heenkenda
 *
 */
public class GiantCrab extends Enemies implements SlamAttack, Resettable {
    private ArrayList<Actor> actorInRange = new ArrayList<>();
    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    RunesManager runesManager = RunesManager.getInstance();
    ResetManager resetManager = ResetManager.getInstance();

    public GiantCrab() {
        super("Giant Crab", 'c', 407);
        behaviours.put(999, new WanderBehaviour());
        runesManager.storeActorsRunes(this,dropRunes());
        resetManager.registerResettable(this, this);
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(behaviours.get(999) instanceof WanderBehaviour == true){
            if(RandomNumberGenerator.getRandomInt(100)<= 10){
                resetManager.removeResettable(this); //Remove actor from reset hashmap
                map.removeActor(this);
                System.out.println(this + " removed from map");
                return new DoNothingAction();
            }
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The lone wolf can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        FollowBehaviour followBehaviour = new FollowBehaviour(otherActor);
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction, equipWeapon(otherActor)));
            actions.add(new AttackActionIntrinsic(this, direction));
            // HINT 1: The AttackAction above allows you to attak the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?
            if(followContained(followBehaviour) == false){
                behaviours.clear();
                behaviours.put(1, new AttackBehaviourSlam(otherActor));
                behaviours.put(500, followBehaviour);
            }
        }

        return actions;
    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);


    }

    public void SlamAttack(GameMap map) {
        scanAround(map);
        for(Actor actor: actorInRange){
            if(RandomNumberGenerator.getRandomInt(100)<=90){
                actor.hurt(97);
                System.out.println(actor + " is slammed for 97 damage.");
                if(actor.isConscious() == false){
                    map.removeActor(actor);
                    System.out.println(actor + " has been killed.");
                }
            }
        }
        actorInRange.clear();




    }

    public void scanAround(GameMap map){
        Location crabLocation = map.locationOf(this);
        int xLocation = crabLocation.x();
        int yLocation = crabLocation.y();

        for(int x = xLocation - 1; x <= xLocation + 1; x++){
            for(int y = yLocation - 1; y <= yLocation + 1; y++){
                Location tempLocation = new Location(map, x, y);
                if(map.isAnActorAt(tempLocation)){
                    if(xLocation != x && yLocation != y){
                        actorInRange.add(map.getActorAt(tempLocation));
                    }
                }
            }
        }
    }
    public boolean followContained(FollowBehaviour behaviourContained){
        for(int i : behaviours.keySet()){
            if(behaviours.get(i) == behaviourContained){
                return true;
            }
        }
        return false;
    }

    public int dropRunes()
    {
        return RandomNumberGenerator.getRandomInt(318, 4961);
    }

    /**
     * Part of the resetting, when Site of Lost Grace or Death of player occurs
     */
    @Override
    public void reset(GameMap gameMap) {

        gameMap.removeActor(this);
    }

    /**
     * Tells us whether this is the player or not
     *
     * @return false, this is not player
     */
    @Override
    public boolean isPlayer() { return false; }


    /**
     * Does nothing for an enemy.
     * @param lastSiteOfGrace
     */
    @Override
    public void setLastSiteOfGrace(Location lastSiteOfGrace) { }


    public Weapon equipWeapon(Actor actor){
        for(Weapon weapon : actor.getWeaponInventory()){
            System.out.println(asWeapon(weapon));
            if(asWeapon(weapon) != null){

                return weapon;
            }
        }
        return actor.getIntrinsicWeapon();
    }
    public Weapon asWeapon(Weapon weapon){
        return weapon instanceof Weapon ? weapon : null;
    }

}
