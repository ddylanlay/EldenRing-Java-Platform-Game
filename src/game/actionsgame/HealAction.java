package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 *
 */
public class HealAction extends Action {

    private int healIncrease;
    private Actor target;

    /**
     *
     * @param target
     * @param healthIncrease
     */
    public HealAction(Actor _target, int _healthIncrease){

        this.target = _target;
        this.healIncrease = _healthIncrease;

    }

    @Override
    public String execute(Actor actor, GameMap map) {

        String result = "Replenished " + actor.toString() + " by " + this.healIncrease + " health.";
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
