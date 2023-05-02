package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.trading.PurchasableItem;
import game.trading.RunesManager;

public class PurchaseAction extends Action {

    private PurchasableItem purchaseWeapon;
    private Actor actor;
    private WeaponItem weapon;
    RunesManager runesManager = RunesManager.getInstance();
    public PurchaseAction(Actor target, WeaponItem weapon, PurchasableItem purchaseWeapon){
        this.actor = target;
        this.weapon = weapon;
        this.purchaseWeapon = purchaseWeapon;
    }

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
