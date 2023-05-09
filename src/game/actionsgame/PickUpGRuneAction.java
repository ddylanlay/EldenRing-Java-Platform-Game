package game.actionsgame;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.GoldenRunes;

public class PickUpGRuneAction extends PickUpAction {

    private GoldenRunes item;

    public PickUpGRuneAction(GoldenRunes item) {
        super(item);
        this.item = item;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map){
        item.addConsumeAction();
        actor.addItemToInventory(item);
        return super.execute(actor, map);
    }
}
