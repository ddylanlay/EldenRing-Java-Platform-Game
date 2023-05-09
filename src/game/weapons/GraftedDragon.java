package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.trading.SellableItem;

/**
 * Grafted Dragon weapon, only obtainable by trading a Remembrance of Grafted from Enia.
 *
 * Deals 89 damage with a 90% hit rate.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class GraftedDragon extends WeaponItem implements SellableItem {

    /**
     * Constructor.
     *
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "bite", 90);
    }

    /**
     * Selling price of the Grafted Dragon.
     *
     * @return an integer representing its selling price.
     */
    @Override
    public int getSellingPrice() {
        int sellingPrice = 200;
        return sellingPrice;
    }
}
