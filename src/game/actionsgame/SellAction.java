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
    private SellableItem weapon1;
    RunesManager runesManager = RunesManager.getInstance();
    private Player player;
    public SellAction(Actor target, WeaponItem weapon, SellableItem weapon1){
        this.actor = target;
        this.weapon = weapon;
        this.weapon1 = weapon1;
    }
    public String sell(Actor actor){
        Player player1 = (Player) actor;
        player1.addRunes(weapon1.getSellingPrice());
        player1.removeWeaponFromInventory(weapon);
        return menuDescription(actor);

    }


    @Override
    public String execute(Actor actor, GameMap map) {
        return sell(actor);
    }


    @Override
    public String menuDescription(Actor actor){
        return actor + " sells " + weapon + " for " + weapon1.getSellingPrice();
    }
}
