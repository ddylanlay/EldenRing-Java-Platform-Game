package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;

/**
 * Golden Runes Item Class
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class GoldenRunes extends ConsumeableItem {

    /***
     * Constructor.
     *
     */
    public GoldenRunes() {

        super("Golden Runes", '*', true);
    }

    @Override
    public void consume() {

    }

    @Override
    public String consume(Actor actor, int healthAmount) {
        return null;
    }
}
