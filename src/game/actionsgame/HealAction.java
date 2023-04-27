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

//    /**
//     *
//     * @param target
//     * @param healthIncrease
//     */
//    public HealAction(Actor _target, int _healthIncrease){
//
//        this.target = _target;
//        this.healIncrease = _healthIncrease;
//
//    }
    public String heal(Actor actor, FlaskOfCrimsonTears bottle){
        actor.heal(HEALTH_INCREASE);
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
