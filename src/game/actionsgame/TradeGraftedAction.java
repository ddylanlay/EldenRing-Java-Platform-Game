package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.RemembranceOfGrafted;

/**
 * Action that allows Trade of Remembrance of Grafted for Axe of Godrick or Grafted Dragon.
 */
public class TradeGraftedAction extends Action {

    /**
     * Remembrance of Grafted Instance
     */
    RemembranceOfGrafted graftedItem;

    /**
     * Trader we are trading with
     */
    Actor trader;

    /**
     * Weapon we are trading for
     */
    WeaponItem weapon;

    /**
     * Constructor.
     *
     * @param graftedItem The Remembrace of the Grafted Item.
     */
    public TradeGraftedAction(RemembranceOfGrafted graftedItem, Actor trader, WeaponItem weapon){

        this.graftedItem = graftedItem;
        this.trader = trader;
        this.weapon = weapon;
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
        return "Trade a " + graftedItem.toString() + " with " + trader.toString() + " for " + weapon.toString() + ".";
    }
}
