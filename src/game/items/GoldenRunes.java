package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.actionsgame.ConsumeRuneAction;
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

    /***
     * Constructor.
     *
     */
    public GoldenRunes() {

        super("Golden Runes", '*', true);
        addCapability(ItemCapability.RUNE_CONSUME);
    }

    public void addConsumeAction(){
        addAction(new ConsumeRuneAction(this));
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

    @Override
    public void consume() {

    }

    @Override
    public String consume(Actor actor, int healthAmount) {
        return null;
    }
}
