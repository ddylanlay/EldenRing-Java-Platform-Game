package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.actionsgame.ConsumeRuneAction;
import game.actionsgame.DropGRuneAction;
import game.actionsgame.PickUpGRuneAction;

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

    ConsumeRuneAction consumeAction;

    /***
     * Constructor.
     *
     */
    public GoldenRunes() {

        super("Golden Runes", '*', true);
        addCapability(ItemCapability.RUNE_CONSUME);
    }

    public void addConsumeAction(){
        if (consumeAction == null) {
            consumeAction = new ConsumeRuneAction(this);
            addAction(consumeAction);
        }
    }

    public void removeConsumeAction(){
        if (consumeAction != null){
            removeAction(consumeAction);
            consumeAction = null;
        }
    }

    /**
     *
     * @param actor
     * @return
     */
    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if(portable)
            return new PickUpGRuneAction(this);
        return null;
    }

    /**
     *
     * @param actor
     * @return
     */
    @Override
    public DropAction getDropAction(Actor actor) {
        if(portable)
            return new DropGRuneAction(this);
        return null;
    }

    @Override
    public void consume() {

    }

    @Override
    public String consume(Actor actor, int healthAmount) {
        return null;
    }
}
