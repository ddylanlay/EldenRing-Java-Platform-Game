package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.GoldenRunes;
import game.utils.RandomNumberGenerator;

/**
 * Consume action for the Golden Runes
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class ConsumeRuneAction extends Action {

    /**
     * Golden Runes instance that will be consumed.
     */
    GoldenRunes gRunes;

    /**
     * Constructor.
     *
     * @param runes The Golden Runes instance.
     */
    public ConsumeRuneAction(GoldenRunes runes){
        this.gRunes = runes;
    }

    /**
     * Execute the consume action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String description of what has occurred.
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        //Consume the golden runes
        String result = menuDescription(actor) + "\n";
        result += gRunes.consume(actor, RandomNumberGenerator.getRandomInt(200, 10000));
        //Remove item from inventory
        actor.removeItemFromInventory(gRunes);
        return result;
    }

    /**
     * Menu description for action.
     *
     * @param actor The actor performing the action.
     * @return String for menu description.
     */
    @Override
    public String menuDescription(Actor actor) { return actor + " consumes the Golden Runes."; }

}
