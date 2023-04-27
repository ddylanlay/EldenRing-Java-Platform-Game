package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Player;
import game.trading.RunesManager;
import game.trading.SellableItem;

import java.util.ArrayList;

public class SellAction extends Action {
    private ArrayList<Actor> actorInRange = new ArrayList<>();
    private Player player;
    WeaponItem weapon;
    SellableItem sellWeapon;
    private Actor actor;
    RunesManager runesManager = RunesManager.getInstance();

    public SellAction(Actor target, WeaponItem weapon, SellableItem sellWeapon) {
        this.actor = target;
        this.weapon = weapon;
        this.sellWeapon = sellWeapon;
    }

    public String sell( Actor actor, SellableItem sellWeapon, WeaponItem weapon) {

        runesManager.addRunes(actor, sellWeapon.getSellingPrice());
        actor.removeWeaponFromInventory(weapon);
        return menuDescription(actor);

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return sell(actor, sellWeapon, weapon);
    }


    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + sellWeapon + " for " + sellWeapon.getSellingPrice();
    }
}
