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
import game.behaviours.*;
import game.combatclass.CombatClass;
import game.trading.RunesManager;
import game.utils.RandomNumberGenerator;
import game.weapons.Scimitar;

import java.util.ArrayList;

/**
 * Giant Dog Enemy.
 *
 * Created by:
 * @author Jamie Tran
 *
 * Modified by:
 * @author Arosh Heenkenda
 *
 */
public class Ally extends Enemies implements Resettable {

    private ArrayList<Actor> actorInRange = new ArrayList<>();

    ResetManager resetManager = ResetManager.getInstance();
    RunesManager runesManager = RunesManager.getInstance();
    private CombatClass combatClass;

    public Ally(CombatClass combatClass) {
        super("Ally", 'A', combatClass.getMaxHitPoints());
        behaviours.put(999, new WanderBehaviour());
        resetManager.registerResettable(this, this);
        runesManager.storeActorsRunes(this,dropRunes());
        this.combatClass = combatClass;
        this.addCapability(Status.ALLY);
        this.addWeaponToInventory(combatClass.getClassWeapon());

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
        if(!otherActor.hasCapability(Status.ALLY)){
            actions.add(new AttackAction(this, direction, equipWeapon(otherActor)));
            actions.add(new AttackActionIntrinsic(this, direction));

            if(!followContained(followBehaviour)){

                behaviours.put(1, new AttackBehaviourWithWeapon(otherActor));
                behaviours.put(500, followBehaviour);
            }
        }

        return actions;
    }
    public boolean followContained(FollowBehaviour behaviourContained){
        for(int i : behaviours.keySet()){
            if(behaviours.get(i) == behaviourContained){
                return true;
            }
        }
        return false;
    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(11, "hits", 100);


    }



    /**
     * Reset method for Giant Dog, removes them from player game map.
     *
     * @param gameMap the game map the player is on, class GameMap.
     */
    @Override
    public void reset(GameMap gameMap) { gameMap.removeActor(this); }

    /**
     * Tells us whether this is the player or not.
     *
     * @return false, not the player.
     */
    @Override
    public boolean isPlayer() { return false; }


    /**
     * Does nothing for an enemy.
     * @param lastSiteOfGrace
     */
    @Override
    public void setLastSiteOfGrace(Location lastSiteOfGrace) { }


    public int dropRunes()
    {
        return RandomNumberGenerator.getRandomInt(0, 0);
    }

}


