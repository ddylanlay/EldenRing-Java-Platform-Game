package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.trading.PurchasableItem;
import game.trading.RunesManager;

/**
 * The Purchase Action.
 *
 * Created by:
 * @author Dylan Lay
 *
 * Modified by:
 *
 */
public class PurchaseAction extends Action {

    /**
     * The weapon to be purchased.
     */
    private PurchasableItem purchaseWeapon;

    /**
     * Unsued actor.
     */
    private Actor actor;

    /**
     * The weapon item instance.
     */
    private WeaponItem weapon;

    /**
     * Runes manager, to deal with rune exchange.
     */
    RunesManager runesManager = RunesManager.getInstance();

    /**
     * Constructor.
     *
     * @param target actor purchasing.
     * @param weapon the weapon item instance.
     * @param purchaseWeapon weapon to sell, as PurchasableItem interface.
     */
    public PurchaseAction(Actor target, WeaponItem weapon, PurchasableItem purchaseWeapon){
        this.actor = target;
        this.weapon = weapon;
        this.purchaseWeapon = purchaseWeapon;
    }

    /**
     * Trade method.
     *
     * @param actor that does the trading.
     * @return
     */
    public String trade(Actor actor){
        if(runesManager.retrieveActorsRunes(actor)< purchaseWeapon.getPurchasePrice()){
            return "Not enough runes to purchase weapon!";
        }
        else{
            runesManager.removeRunes(actor, purchaseWeapon.getPurchasePrice());
            actor.addWeaponToInventory(weapon);
            return menuDescription(actor);
        }

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return trade(actor);
    }
    @Override
    public String menuDescription(Actor actor){
        return actor + " purchases " + weapon + " for " + purchaseWeapon.getPurchasePrice();
    }

}
