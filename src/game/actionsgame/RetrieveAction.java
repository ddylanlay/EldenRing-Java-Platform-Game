package game.actionsgame;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Runes;
import game.trading.RunesManager;

/**
 * Retrieve Action for normal runes.
 *
 * Created by:
 * @author Dylan Lay
 *
 * Modified by:
 * @author Arosh Heenkenda
 *
 */
public class RetrieveAction extends PickUpAction {

    /**
     * Runes object.
     */
    private Runes runes;

    /**
     * Runes manager.
     */
    RunesManager runesManager = RunesManager.getInstance();

    /**
     * Constructor.
     *
     * @param _runes the runes object.
     */
    public RetrieveAction(Runes _runes){
        super(_runes);
        this.runes = _runes;
    }

    /**
     * Executing the action.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string description of what has occurred.
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        runesManager.addRunes(actor, runes.getValue()); //Add runes back
        return super.execute(actor, map); //Remove item from the map
    }

    /**
     * Menu description for the action.
     *
     * @param actor The actor performing the action.
     * @return string of the menu description.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " retrieves Runes (value: " + runes.getValue() + ")";
    }

}
