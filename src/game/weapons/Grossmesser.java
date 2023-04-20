package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Grossmesser extends WeaponItem implements SellableItem {
    public Grossmesser(){
        super("Grossmesser", '?', 115, "slashes", 85);

    public int getSellingPrice(){
        int sellingPrice = 100;
        return sellingPrice;
    }
    }
}
