package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.*;

/**
 * Flask of Crimson Tears, allows the Player to gain 250 health points.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class FlaskOfCrimsonTears extends ConsumeableItem {

    /**
     *
     */
    final int MAX_USES = 2;

    /**
     *
     */
    private int currentUses = MAX_USES;

    /**
     * Constructor.
     */
    public FlaskOfCrimsonTears() { super("Flask of Crimson Tears", 'c', false); }

    /**
     *
     * @return
     */
    public int getCurrentUses() {
        return currentUses;
    }

    /**
     *
     * @param actor
     * @return
     */
    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if(portable)
            return new PickUpItemAction(this);
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
            return new DropItemAction(this);
        return null;
    }


    /**
     *
     * @param actor
     */
    @Override
    void consume(Actor actor) {

    }
}
