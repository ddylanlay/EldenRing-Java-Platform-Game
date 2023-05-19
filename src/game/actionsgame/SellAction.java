package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.trading.RunesManager;
import game.trading.SellableItem;

public class SellAction extends Action {
    private SellableItem sellWeapon;
    private Actor actor;
    RunesManager runesManager = RunesManager.getInstance();

    public SellAction(Actor target, SellableItem sellWeapon) {
        this.actor = target;
        this.sellWeapon = sellWeapon;
    }

    public String sell(Actor actor, SellableItem sellWeapon) {
        runesManager.addRunes(actor, sellWeapon.getSellingPrice());
        sellWeapon.removeWeaponToActor(actor);
        return menuDescription(actor);

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return sell(actor, sellWeapon);
    }
    public String theMenuDescription(Actor actor, SellableItem sellWeapon) {
        return actor + " sells " + sellWeapon.toString() + " for " + sellWeapon.getSellingPrice();
    }
    @Override
    public String menuDescription(Actor actor) {
        return theMenuDescription(actor, sellWeapon);
    }

}
