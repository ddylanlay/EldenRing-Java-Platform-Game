package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.trading.PurchasableItem;
import game.trading.SellableItem;
import game.weaponabilities.SpinAttack;

/**
 * A curved sword that both enemies and player can use to attack.
 * It deals 118 damage with 88% hit rate
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 * @author Jamie Tran
 *
 */
public class Scimitar extends WeaponItem implements SpinAttack, PurchasableItem, SellableItem {
    /**
     * Constructor
     */
    public Scimitar() { super("Scimitar", 's', 118, "slashes", 88); }

    public int getPurchasePrice(){
        int purchasePrice = 600;
        return purchasePrice;
    }
    public int getSellingPrice(){
        int sellingPrice = 100;
        return sellingPrice;
    }

    @Override
    public void spinAttack() {

    }

}
