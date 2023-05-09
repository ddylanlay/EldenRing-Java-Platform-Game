package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.actionsgame.ConsumeRuneAction;
import game.actionsgame.DropGRuneAction;
import game.actionsgame.PickUpGRuneAction;
import game.trading.RunesManager;
import game.utils.RandomNumberGenerator;

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

    private ConsumeRuneAction consumeAction;

    /***
     * Constructor.
     *
     */
    public GoldenRunes() {

        super("Golden Runes", '*', true);
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

    /**
     *
     * @param actor
     * @param amount
     * @return
     */
    @Override
    public String consume(Actor actor, int amount) {

        //Transfer runes to the player
        RunesManager runesManager = RunesManager.getInstance();
        runesManager.addRunes(actor, amount);
        return actor + " gains " + amount + " runes.";
    }
}
