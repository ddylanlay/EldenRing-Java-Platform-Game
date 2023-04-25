package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Player;
import game.trading.SellableItem;

public class SellAction extends Action {

    private final WeaponItem weapon;
    Actor actor;
    public SellAction(Actor target, WeaponItem weapon){
        this.actor = target;
        this.weapon = weapon;
    }

    public String sell(SellableItem weapon, Player player){
        player.addRunes(weapon.getSellingPrice());
        player.removeWeaponFromInventory((WeaponItem) weapon);
        return theMenuDescription(weapon, player);

    }
    @Override
    public String execute(Actor actor, GameMap map) {
        return sell((SellableItem) weapon, (Player) actor);
    }
    public String theMenuDescription(SellableItem weapon, Player player){
        return player + " sells " + weapon + " for " + weapon.getSellingPrice();
    }
    public String menuDescription(Actor actor){
        return theMenuDescription((SellableItem) weapon, (Player) actor);
    }
}
