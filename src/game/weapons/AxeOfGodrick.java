package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.trading.SellableItem;

/**
 * Axe of Godrick weapon, only obtainable by trading a Remembrance of Grafted from Enia.
 *
 * Deals 142 damage with an 84% hit rate.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class AxeOfGodrick extends WeaponItem implements SellableItem {

    /**
     * Constructor.
     *
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "swing", 84);
    }

    /**
     * Selling price of Axe of Godrick.
     *
     * @return an integer representing the price.
     */
    @Override
    public int getSellingPrice() {
        int sellingPrice = 100;
        return sellingPrice;
    }
}
