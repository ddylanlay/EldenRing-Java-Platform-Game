package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Resettable;
import game.Status;
import game.actionsgame.AttackAction;
import game.behaviours.Behaviour;
import game.trading.RunesManager;
import game.utils.RandomNumberGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * SB Pile of Bones Enemy.
 *
 * Created by:
 * @author Jamie Tran
 *
 * Modified by:
 * @author Arosh Heenkenda
 */
public class PilesOfBonesSB extends Enemies implements Resettable {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    RunesManager runesManager = RunesManager.getInstance();
    private int Counter = 0;

    public PilesOfBonesSB(){
        super("Piles of Bones", 'X', 1);
        runesManager.storeActorsRunes(this,dropRunes());


    }

    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(this.isConscious() && Counter >= 3){
            Location currentLocation = map.locationOf(this);
            map.removeActor(this);
            System.out.println("Skeletal Bandit respawned");
            map.addActor(new SkeletalBandit(), currentLocation);
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        Counter += 1;

        return new DoNothingAction();
    }
    public int dropRunes()
    {
        return RandomNumberGenerator.getRandomInt(35, 892);
    }


    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction, equipWeapon(otherActor)));
            actions.add(new AttackAction(this, direction));
            // HINT 1: The AttackAction above allows you to attak the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?
        }
        return actions;
    }

    /**
     * Reset method for SB Pile of Bones, removes from player map.
     *
     * @param gameMap, game map the player is on, class GameMap.
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

