package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.PurchasableItem;
import game.SellableItem;
/**
 * A katana weapon that can be used to attack the enemy.
 * It deals 115 damage with 80% hit rate
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class Uchigatana extends WeaponItem implements PurchasableItem, SellableItem {
    /**
     * Constructor
     */

    public Uchigatana(){ super("Uchigatana", ')', 115, "slashes", 80); }


    public int getPurchasePrice(){
        int purchasePrice = 5000;
        return purchasePrice;
    }
    public int getSellingPrice(){
        int sellingPrice = 500;
        return sellingPrice;
    }
}
