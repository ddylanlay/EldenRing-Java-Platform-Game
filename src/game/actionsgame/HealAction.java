package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.FlaskOfCrimsonTears;

/**
 * Healing Action.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 * @Dylan Lay
 */
public class HealAction extends Action {

    /**
     * Amount to be healed by.
     */
    final int HEALTH_INCREASE = 250;

    /**
     * Instance of Flask of Crimson Tears
     */
    public FlaskOfCrimsonTears bottle = FlaskOfCrimsonTears.getInstance();

    /**
     * Heal action.
     *
     * @param actor actor to be healed.
     * @param bottle   instance of Flask of Crimson Tears.
     * @return string description of what occured.
     */
    public String heal(Actor actor, FlaskOfCrimsonTears bottle){

        return bottle.consume(actor, HEALTH_INCREASE);
    }

    /**
     * Execute the healing.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string description of what happened.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return heal(actor, bottle);
    }

    /**
     * Menu description.
     *
     * @param actor The actor performing the action.
     * @return string of what occured.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + bottle.toString() + " (" + bottle.remainingUses + "/" + bottle.MAX_USES + ").";
    }
}
