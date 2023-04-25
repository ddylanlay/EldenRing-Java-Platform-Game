package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.trading.PurchasableItem;

public class PurchaseAction extends Action {

    PurchasableItem weapon;
    Actor actor;
    public PurchaseAction(Actor target, PurchasableItem weapon){
        this.actor = target;
        this.weapon = weapon;
    }

    public String trade(Player player){
        if(player.getNumOfRunes() < weapon.getPurchasePrice()){
            return "Not enough runes to purchase weapon!";
        }
        else{
            player.removeRunes(weapon.getPurchasePrice());
            return menuDescription(player);
        }

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return trade ((Player) actor);
    }

    public String menuDescription(Actor actor){
        return actor + " purchases " + weapon + " for " + weapon.getPurchasePrice();
    }

}
