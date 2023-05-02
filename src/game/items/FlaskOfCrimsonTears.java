package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
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
    private static FlaskOfCrimsonTears instance;

    /**
     * Constructor.
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", 'c', false);

    }
    public static FlaskOfCrimsonTears getInstance() {
        if (instance == null) {
            instance = new FlaskOfCrimsonTears();
        }
        return instance;
    }

    @Override
    public void consume() { }

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
    public String consume(Actor actor, int healAmount){

        if (remainingUses != 0) {
            remainingUses -= 1;
            actor.heal(healAmount);
            return actor + " consumes " + this + " (" + remainingUses + "/" + MAX_USES + ")";
        }
        else{
            return this + " (" + remainingUses + "/" + MAX_USES + ") is empty.";
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
     * For game reset, will set remaining uses to the max uses.
     */
    @Override
    public void reset(GameMap gameMap) { remainingUses = MAX_USES; }

    @Override
    public boolean isPlayer() { return false; }

    @Override
    public void setLastSiteOfGrace(Location lastSiteOfGrace) {

    }


}
