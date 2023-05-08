package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.GoldenRunes;

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

    GoldenRunes gRunes;

    public ConsumeRuneAction(GoldenRunes runes){

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {

        return actor + " consumes the Golden Runes.";
    }
}
