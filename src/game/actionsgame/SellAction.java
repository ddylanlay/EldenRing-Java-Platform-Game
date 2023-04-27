package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Player;
import game.trading.RunesManager;
import game.trading.SellableItem;

public class SellAction extends Action {

    private WeaponItem weapon;
    private Actor actor;
    RunesManager runesManager = RunesManager.getInstance();
    private Player player;
    public SellAction(Actor target, WeaponItem weapon){
        this.actor = target;
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        player.addRunes(((SellableItem) weapon).getSellingPrice());
        player.removeWeaponFromInventory(weapon);
        return menuDescription(player);
    }
    @Override
    public String menuDescription(Actor actor){
        return actor + " sells " + weapon + " for " + ((SellableItem) weapon).getSellingPrice();
    }
}
