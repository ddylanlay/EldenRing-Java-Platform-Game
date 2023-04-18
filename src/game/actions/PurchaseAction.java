package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.PurchaseableItem;

public class PurchaseAction extends Action {

    PurchaseableItem weapon;
    Actor actor;
    public PurchaseAction(Actor actor, PurchaseableItem weapon){
        this.actor = actor;
        this.weapon = weapon;
    }
    public String execute(Actor actor, GameMap map){

    }

    public String menuDescription(Actor actor){
        return actor + "purchased the " + weapon;
    }

}
