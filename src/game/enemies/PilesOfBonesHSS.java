package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Resettable;
import game.Status;
import game.actionsgame.AttackAction;
import game.behaviours.Behaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * HSS Pile of Bones Enemy.
 *
 * Created by:
 * @author Jamie Tran
 *
 * Modified by:
 * @author Arosh Heenkenda
 */
public class PilesOfBonesHSS extends Enemies implements Resettable {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    private int Counter = 0;

    public PilesOfBonesHSS(){
        super("Piles of Bones", 'X', 1);


    }

    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(!this.isConscious() && Counter >= 3){
            Location currentLocation = map.locationOf(this);
            map.removeActor(this);

            map.addActor(new HeavySkeletalSwordsman(), currentLocation);
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        Counter += 1;

        return new DoNothingAction();
    }


    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
            // HINT 1: The AttackAction above allows you to attak the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?
        }
        return actions;
    }

    /**
     * Reset method for HSS Pile of Bones, removes them from player map.
     *
     * @param gameMap game map player is on, class GameMap.
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
}
