package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.trading.PurchasableItem;
import game.trading.RunesManager;

public class PurchaseAction extends Action {

    PurchasableItem weapon;
    Actor actor;
    RunesManager runesManager = RunesManager.getInstance();
    public PurchaseAction(Actor target, PurchasableItem weapon){
        this.actor = target;
        this.weapon = weapon;
    }

    public String trade(Actor actor){
        if(runesManager.retrieveActorsRunes(actor)< weapon.getPurchasePrice()){
            return "Not enough runes to purchase weapon!";
        }
        else{
            runesManager.addRunes(actor, weapon.getPurchasePrice());
            actor.addWeaponToInventory((WeaponItem) weapon);
            return menuDescription(actor);
        }

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return trade (actor);
    }
    @Override
    public String menuDescription(Actor actor){
        return actor + " purchases " + weapon + " for " + weapon.getPurchasePrice();
    }

}
