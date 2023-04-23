package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.*;
import game.Resettable;
import game.actionsgame.HealAction;

/**
 * Flask of Crimson Tears, allows the Player to gain 250 health points.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class FlaskOfCrimsonTears extends ConsumeableItem implements Resettable {

    /**
     *
     */
    final int MAX_USES = 2;

    /**
     *
     */
    final int HEALTH_INCREASE = 250;

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
    public HealAction consume(Actor actor) {

        if (currentUses == 0){

            System.out.println(this + " is empty, cannot be used until it is refilled.");
        }
        else {


            actor.heal(HEALTH_INCREASE);
            currentUses -= 1;
        }
    }

    /**
     *
     */
    @Override
    public void reset() {

    }
}
