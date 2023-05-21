package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.trading.RunesManager;
import game.trading.SellableItem;

public class SellAction extends Action {
    private SellableItem sellWeapon;
    private Actor actor;
    RunesManager runesManager = RunesManager.getInstance();

    /**
     *  Constructor
     * @param target actor wanting to sell
     * @param sellWeapon the weapon to be sold
     */
    public SellAction(Actor target, SellableItem sellWeapon) {
        this.actor = target;
        this.sellWeapon = sellWeapon;
    }

    /**
     * Selling the weapon
     * @param actor actor wanting to sell
     * @param sellWeapon the weapon to be sold
     * @return string menuDescription
     */
    public String sell(Actor actor, SellableItem sellWeapon) {
        runesManager.addRunes(actor, sellWeapon.getSellingPrice());
        sellWeapon.removeWeaponToActor(actor);
        return menuDescription(actor);

    }

    /**
     * Executing the sell action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string menuDescription
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return sell(actor, sellWeapon);
    }

    /**
     *  Menu description of selling action
     * @param actor The actor performing the action.
     * @return string menuDescription
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + sellWeapon.toString() + " for " + sellWeapon.getSellingPrice();
    }

}
