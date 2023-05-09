package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Resettable;
import game.actionsgame.HealAction;
import java.util.List;

/**
 * Flask of Crimson Tears, allows the Player to gain 250 health points.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 * @author Dylan Lay
 *
 */
public class FlaskOfCrimsonTears extends ConsumeableItem implements Resettable {

    /**
     * The max number of uses.
     */
    public final int MAX_USES = 2;

    /**
     * The number of remaining uses.
     */
    public int remainingUses = MAX_USES;

    /**
     * Instance of Flask Of Crimson Tears.
     */
    private static FlaskOfCrimsonTears instance;

    /**
     * Constructor.
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", 'c', false);
    }

    /**
     * Factory getInstance method.
     *
     * @return single instance of Flask Of Crimson Tears.
     */
    public static FlaskOfCrimsonTears getInstance() {
        if (instance == null) {
            instance = new FlaskOfCrimsonTears();
        }
        return instance;
    }


    /**
     * Consume action for Flask of Crimson Tears, will heal the actor given there are uses remaining.
     *
     * @param actor The actor to be healed.
     * @param amount The amount to be healed by.
     * @return String description of the action performed.
     */
    @Override
    public String consume(Actor actor, int amount){

        if (remainingUses != 0) {
            remainingUses -= 1;
            actor.heal(amount);
            return actor + " consumes " + this + " (" + remainingUses + "/" + MAX_USES + ")";
        }
        else{
            return this + " (" + remainingUses + "/" + MAX_USES + ") is empty.";
        }

    }

    /**
     * Simple to string method.
     * @return
     */
    public String toString() { return super.toString(); }

    /**
     * Get the allowable actions for this item, also adds healing capability.
     * @return unmodifiable actions list.
     */
    public List<Action> getAllowableActions() {
        ActionList actions = new ActionList();
        actions.add(new HealAction());

        return actions.getUnmodifiableActionList();
    }

    /**
     * For game reset, will set remaining uses to the max uses.
     */
    @Override
    public void reset(GameMap gameMap) { remainingUses = MAX_USES; }

    /**
     * Tells us whether this is the player or not.
     *
     * @return false, not the player.
     */
    @Override
    public boolean isPlayer() { return false; }

    /**
     * Will do nothing, as its not the player
     *
     * @param lastSiteOfGrace
     */
    @Override
    public void setLastSiteOfGrace(Location lastSiteOfGrace) {  }


}
