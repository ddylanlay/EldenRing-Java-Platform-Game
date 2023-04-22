package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.trading.PurchasableItem;

public class PurchaseAction extends Action {

    PurchasableItem weapon;
    Actor actor;
    Player player;
    public PurchaseAction(Actor target, PurchasableItem weapon){
        this.actor = target;
        this.weapon = weapon;
    }
    public String execute(Player player, GameMap map){
        if(player.getNumOfRunes() < weapon.getPurchasePrice()){
            return "Not enough runes to purchase weapon!";
        }
        else{
            player.dropRunes(weapon.getPurchasePrice());
            return menuDescription(player);
        }

    }

    public String menuDescription(Actor actor){
        return actor + "purchased the " + weapon;
    }

}
