package game.trading;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.*;

public class Runes extends Item {
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Runes(String name, char displayChar, boolean portable) {
        super("Runes", '$', true);
    }
    public PickUpAction getPickUpAction(Actor actor) {
        if(portable)
            return new PickUpItemAction(this);
        return null;
    }
    public DropAction getDropAction(Actor actor) {
        if(portable)
            return new DropItemAction(this);
        return null;
    }

}
