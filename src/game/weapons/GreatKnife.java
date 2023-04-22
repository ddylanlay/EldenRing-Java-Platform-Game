package game.weapons;

import game.trading.PurchasableItem;
import game.trading.SellableItem;

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
