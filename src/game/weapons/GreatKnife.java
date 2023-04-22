package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.trading.SellableItem;
import game.trading.PurchasableItem;

/**
 * A knife weapon that can be used to attack the enemy.
 * It deals 75 damage with 70% hit rate
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class GreatKnife extends WeaponItem implements PurchasableItem, SellableItem {

    /**
     * Constructor
     */
    public GreatKnife(){ super("Great Knife", '/', 75, "slashes", 70); }

    public int getPurchasePrice(){
        int purchasePrice = 3500;
        return purchasePrice;
    }
    public int getSellingPrice(){
        int sellingPrice = 350;
        return sellingPrice;
    }
}
