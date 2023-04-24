package game.trading;

import edu.monash.fit2099.engine.items.Item;

public class Runes extends Item {

    private final int value;

    public Runes(int value) {
        super("Runes", '$', true);
        this.value = value;
    }



}
