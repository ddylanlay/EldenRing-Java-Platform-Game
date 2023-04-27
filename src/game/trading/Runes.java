package game.trading;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.*;

public class Runes extends Item {

    private final int value;

    public Runes(int value) {
        super("Runes", '$', true);
        this.value = value;
    }

    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if(portable)
            return new PickUpItemAction(this);
        return null;
    }

    @Override
    public DropAction getDropAction(Actor actor) {
        if(portable)
            return new DropItemAction(this);
        return null;
    }



}
