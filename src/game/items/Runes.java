package game.items;

import edu.monash.fit2099.engine.items.Item;

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

    private int value;

    /**
     * Constructor.
     *
     * @param _value the value (number) of runes.
     */
    public Runes(int _value) {
        super("Runes", '$', false);
        this.value = _value;
    }
}
