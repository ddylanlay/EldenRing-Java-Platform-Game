package game.actionsgame;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.GoldenRunes;

/**
 Action to drop Golden Runes.

 Created by:
 @author Arosh Heenkenda

 Modified by:

 */
public class DropGRuneAction extends DropAction {

    /**
     * Golden Runes item.
     */
    private GoldenRunes item;

    /**
     * Constructor.
     *
     * @param item the Golden Runes to drop.
     */
    public DropGRuneAction(GoldenRunes item) {
        super(item);
        this.item = item;
    }

    /**
     * Execute teh drop action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return description of what was done.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        item.removeConsumeAction();
        actor.removeItemFromInventory(item);
        return super.execute(actor, map);
    }
}
