package game.weapons;

import game.PurchasableItem;
import game.SellableItem;

public class GreatKnife implements PurchasableItem, SellableItem {
    public int getPurchasePrice(){
        int purchasePrice = 3500;
        return purchasePrice;
    }
    public int getSellingPrice(){
        int sellingPrice = 350;
        return sellingPrice;
    }
}
