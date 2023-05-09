package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.PickUpAction;
import game.actionsgame.ConsumeRuneAction;
import game.actionsgame.DropGRuneAction;
import game.actionsgame.PickUpGRuneAction;
import game.trading.RunesManager;

/**
 * Golden Runes Item Class
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class GoldenRunes extends ConsumeableItem {

    /**
     * Consume action for the given rune instance.
     */
    private ConsumeRuneAction consumeAction;

    /***
     * Constructor.
     *
     */
    public GoldenRunes() {
        super("Golden Runes", '*', true);
    }

    /**
     * Adds a consume action to the item's action list.
     */
    public void addConsumeAction(){
        if (consumeAction == null) {
            consumeAction = new ConsumeRuneAction(this);
            addAction(consumeAction);
        }
    }

    /**
     * Removes the consume action from the item's action list.
     */
    public void removeConsumeAction(){
        if (consumeAction != null){
            removeAction(consumeAction);
            consumeAction = null;
        }
    }

    /**
     * Pickup action for Golden Runes.
     *
     * @param actor The target actor for the pickup.
     * @return an instance of PickUpGRunAction.
     */
    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if(portable)
            return new PickUpGRuneAction(this);
        return null;
    }

    /**
      Drop action for Golden Runes.

     * @param actor Target actor for the drop.
     * @return an instance of DropGRuneAction.
     */
    @Override
    public DropAction getDropAction(Actor actor) {
        if(portable)
            return new DropGRuneAction(this);
        return null;
    }

    /**
     * The consume method for Golden Runes, will add the specified amount of runes to the target actor.
     *
     * @param actor Target actor that will receive runes.
     * @param amount The amount of runes the actor will receive.
     * @return String description of what has occurred.
     */
    @Override
    public String consume(Actor actor, int amount) {

        //Transfer runes to the player
        RunesManager runesManager = RunesManager.getInstance();
        runesManager.addRunes(actor, amount);
        return actor + " gains " + amount + " runes.";
    }
}
