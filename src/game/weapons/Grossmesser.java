package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.trading.SellableItem;

/**
 * A curved sword that both enemies and player can use to attack.
 * It deals 115 damage with 85% hit rate
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class Grossmesser extends WeaponItem implements SellableItem {
    /**
     * Constructor
     */
    public Grossmesser(){
        super("Grossmesser", '?', 115, "slashes", 85);
    }
    public int getSellingPrice(){
        int sellingPrice = 100;
        return sellingPrice;
    }
}
