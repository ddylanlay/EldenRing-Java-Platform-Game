package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.RemembranceOfGrafted;

/**
 * Action that allows Trade of Remembrance of Grafted for Axe of Godrick or Grafted Dragon.
 */
public class TradeGraftedAction extends Action {

    RemembranceOfGrafted graftedItem;

    /**
     * Constructor.
     *
     * @param graftedItem The Remembrace of the Grafted Item.
     */
    public TradeGraftedAction(RemembranceOfGrafted graftedItem){
        this.graftedItem = graftedItem;
    }

    /**
     * Execute the trade action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String description of the trade.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return "Execute the grafted trade action.";
    }

    /**
     * Menu Description of the trade.
     *
     * @param actor The actor performing the action.
     * @return String for menu description.
     */
    @Override
    public String menuDescription(Actor actor) {

//        System.out.println("We try to do menu description of Trade Grafted Action");

        return "Allow trade for grafted";
    }
}
