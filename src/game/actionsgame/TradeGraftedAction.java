package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Action that allows Trade of Remembrance of Grafted for Axe of Godrick or Grafted Dragon.
 */
public class TradeGraftedAction extends Action {

    /**
     * Execute the trade action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String description of the trade.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    /**
     * Menu Description of the trade.
     *
     * @param actor The actor performing the action.
     * @return String for menu description.
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
