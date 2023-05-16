package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.ResetManager;
import game.Resettable;
import game.Status;
import game.actionsgame.AttackAction;
import game.actionsgame.AttackActionIntrinsic;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.trading.RunesManager;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;

public class Dog extends Enemies implements Resettable {
    private ArrayList<Actor> actorInRange = new ArrayList<>();
    RunesManager runesManager = RunesManager.getInstance();
    ResetManager resetManager = ResetManager.getInstance();

    public Dog() {
        super("Dog", 'a', 104);
        behaviours.put(999, new WanderBehaviour());
        runesManager.storeActorsRunes(this,dropRunes());
        resetManager.registerResettable(this, this);
        this.addCapability(EnemyType.STORMVEIL);
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
        if(behaviours.get(999) instanceof WanderBehaviour){
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


    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        FollowBehaviour followBehaviour = new FollowBehaviour(otherActor);
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && !(otherActor.hasCapability(EnemyType.STORMVEIL))){
            actions.add(new AttackAction(this, direction, equipWeapon(otherActor)));
            actions.add(new AttackActionIntrinsic(this, direction));
            // HINT 1: The AttackAction above allows you to attak the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?
            if(followContained(followBehaviour) == false){
                behaviours.clear();
                behaviours.put(1, new AttackBehaviour(otherActor));
                behaviours.put(500, followBehaviour);
            }
        }

        return actions;
    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);


    }



//    public boolean followContained(FollowBehaviour behaviourContained){
//        for(int i : behaviours.keySet()){
//            if(behaviours.get(i) == behaviourContained){
//                return true;
//            }
//        }
//        return false;
//    }

    public int dropRunes()
    {
        return RandomNumberGenerator.getRandomInt(52, 1390);
    }

    /**
     * Part of the resetting, when Site of Lost Grace or Death of player occurs
     */
    @Override
    public void reset(GameMap gameMap) {

        gameMap.removeActor(this);
    }

    @Override
    public boolean isPlayer() {
        boolean value = false;
        if (this.hasCapability(Status.FAST_TRAVEL)) {
            value = true;
        }
        return value;
    };

    @Override
    public void setLastSiteOfGrace(Location lastSiteOfGrace) {

    }

    /**
     * Tells us whether this is the player or not
     *
     * @return false, this is not player
     */

    /**
     * Does nothing for an enemy.
     * @param lastSiteOfGrace
     */

}

