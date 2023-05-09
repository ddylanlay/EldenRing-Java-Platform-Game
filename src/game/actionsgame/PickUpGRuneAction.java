package game.actionsgame;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.GoldenRunes;

/**
 * Action to pick up Golden Runes.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class PickUpGRuneAction extends PickUpAction {

    /**
     * Golden Runes item to be picked up.
     */
    private GoldenRunes item;

    /**
     * Constructor
     *
     * @param item Golden Runes item.
     */
    public PickUpGRuneAction(GoldenRunes item) {
        super(item);
        this.item = item;
    }

    /**
     * Executing the pick-up action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return Description of the action.
     */
    @Override
    public String execute(Actor actor, GameMap map){
        item.addConsumeAction(); //Add ability to consume
        actor.addItemToInventory(item);
        return super.execute(actor, map);
    }
}
