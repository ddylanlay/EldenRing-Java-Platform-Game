package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.items.Item;
import game.actionsgame.RetrieveAction;

import java.util.List;

/**
 * Normal Runes dropped when a player dies.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class Runes extends Item {

    /**
     * Allowable actions for the item.
     */
    private ActionList allowableActions;

    /**
     * Value of the runes.
     */
    private int value;

    /**
     * Constructor.
     *
     * @param _value the value (number) of runes.
     */
    public Runes(int _value) {
        super("Runes", '$', false);
        this.value = _value;
        this.allowableActions = new ActionList();
        this.allowableActions.add(new RetrieveAction(this));
    }

    /**
     * Get allowable actions for the item.
     *
     * @return an unmodifiable list of item actions.
     */
    @Override
    public List<Action> getAllowableActions() { return this.allowableActions.getUnmodifiableActionList(); }

    /**
     * Getter, gets value attribute.
     *
     * @return an int representing rune value.
     */
    public int getValue() {
        return value;
    }

}
