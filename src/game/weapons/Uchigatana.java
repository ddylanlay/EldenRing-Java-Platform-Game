package game.weapons;

import game.PurchasableItem;
import game.SellableItem;

public class Uchigatana implements PurchasableItem, SellableItem {
    public int getPurchasePrice(){
        int purchasePrice = 5000;
        return purchasePrice;
    }
    public int getSellingPrice(){
        int sellingPrice = 500;
        return sellingPrice;
    }

}
