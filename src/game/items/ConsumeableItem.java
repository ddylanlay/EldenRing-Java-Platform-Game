package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * Abstract Consumeable Item class
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public abstract class ConsumeableItem extends Item {


    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public ConsumeableItem(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
        this.addCapability(ItemCapability.CONSUMEABLE);
    }

    /**
     * Consume method for consumable item.
     *
     * @param actor The actor that will consume the item.
     * @param amount Any amount, what this is will depend on what kind of consumable it is.
     * @return A String description of what has occurred.
     */
    public abstract String consume(Actor actor, int amount);

}
