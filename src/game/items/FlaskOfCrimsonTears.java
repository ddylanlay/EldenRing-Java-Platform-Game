package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import game.Resettable;
import game.actionsgame.HealAction;

import java.util.List;

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
    public final int MAX_USES = 2;
    /**
     *
     */
    public int remainingUses = MAX_USES;

    /**
     * Constructor.
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", 'c', false);

    }

//    @Override
//    public HealAction consume(Actor actor) {
//
//        if (currentUses == 0){
//
//            System.out.println(this + " (" + remainingUses + "/" + MAX_USES + ") is empty.");
//        }
//        else {
//
//
//            actor.heal(HEALTH_INCREASE);
//            currentUses -= 1;
//        }
//    }
    public void consume(){
        if (remainingUses != 0) {
            remainingUses -= 1;
        }
        else{
            System.out.println(this + " (" + remainingUses + "/" + MAX_USES + ") is empty. It cannot be used until it is refilled.");
        }

    }

    public String toString() {
        return super.toString();
    }
    public List<Action> getAllowableActions() {
        ActionList actions = new ActionList();
        actions.add(new HealAction());

        return actions.getUnmodifiableActionList();
    }

    /**
     *
     */
    @Override
    public void reset() {

    }


}
