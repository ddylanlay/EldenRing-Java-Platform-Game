package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Player;
import game.trading.RunesManager;
import game.trading.SellableItem;
import game.weapons.SellableWeaponInventory;

public class SellAction extends Action {

    private WeaponItem weapon;
    private Actor actor;
    private SellableItem weapon1;
    private SellableWeaponInventory sellableWeaponInventory = SellableWeaponInventory.getInstance();
    RunesManager runesManager = RunesManager.getInstance();
    private Player player;
    public SellAction(Actor target, WeaponItem weapon, SellableItem weapon1){
        this.actor = target;
        this.weapon = weapon;
        this.weapon1 = weapon1;
    }
    public String sell(Player player){
        player.addRunes(weapon1.getSellingPrice());
        player.removeWeaponFromInventory(weapon);
        sellableWeaponInventory.removeWeaponFromInventory(weapon1);
        return theMenuDescription(weapon1, player);

    }


    @Override
    public String execute(Actor actor, GameMap map) {
        return sell((Player) actor);
    }

    public String theMenuDescription(SellableItem weapon, Player player){
        return player + " sells " + weapon + " for " + weapon.getSellingPrice();
    }


    @Override
    public String menuDescription(Actor actor){
        return theMenuDescription(weapon1, (Player) actor);
    }
}
