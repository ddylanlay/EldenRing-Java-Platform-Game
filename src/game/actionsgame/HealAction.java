package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.FlaskOfCrimsonTears;

/**
 *
 */
public class HealAction extends Action {

    final int HEALTH_INCREASE = 250;
    public FlaskOfCrimsonTears bottle = FlaskOfCrimsonTears.getInstance();
    public String heal(Actor actor, FlaskOfCrimsonTears bottle){

        if (bottle.remainingUses > 0) {
            actor.heal(HEALTH_INCREASE);

        }

        bottle.consume();
        return menuDescription(actor);
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        return heal(actor, bottle);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + bottle.toString() + " (" + bottle.remainingUses + "/" + bottle.MAX_USES + ").";
    }
}
