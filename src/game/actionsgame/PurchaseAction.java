package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.PurchasableItem;

public class PurchaseAction extends Action {

    PurchasableItem weapon;
    Actor actor;
    public PurchaseAction(Actor actor, PurchasableItem weapon){
        this.actor = actor;
        this.weapon = weapon;
    }
    public String execute(Actor actor, GameMap map){


    }

    public String menuDescription(Actor actor){
        return actor + "purchased the " + weapon;
    }

}
