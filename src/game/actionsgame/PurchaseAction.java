package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Player;
import game.trading.PurchasableItem;
import game.trading.RunesManager;

public class PurchaseAction extends Action {

    PurchasableItem weapon1;
    Actor actor;
    Player player;
    WeaponItem weapon;
    RunesManager runesManager = RunesManager.getInstance();
    public PurchaseAction(Actor target, WeaponItem weapon, PurchasableItem weapon1){
        this.actor = target;
        this.weapon = weapon;
        this.weapon1 = weapon1;
    }

    public String trade(Player player){
        if(player.getNumOfRunes()< weapon1.getPurchasePrice()){
            return "Not enough runes to purchase weapon!";
        }
        else{
            runesManager.removeRunes(player, weapon1.getPurchasePrice());
            player.addWeaponToInventory(weapon);
            return menuDescription(player);
        }

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return trade((Player) actor);
    }
    @Override
    public String menuDescription(Actor actor){
        return actor + " purchases " + weapon + " for " + weapon1.getPurchasePrice();
    }

}
