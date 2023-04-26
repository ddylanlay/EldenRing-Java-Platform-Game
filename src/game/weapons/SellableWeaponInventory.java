package game.weapons;

import game.trading.SellableItem;

import java.util.ArrayList;
import java.util.List;

public class SellableWeaponInventory {
    private List<SellableItem> sellableWeaponInventory;
    private static SellableWeaponInventory instance;
    private SellableWeaponInventory() {
        this.sellableWeaponInventory = new ArrayList<>();
    }

    public static SellableWeaponInventory getInstance() {
        if (instance == null) {
            instance = new SellableWeaponInventory();
        }
        return instance;
    }
    /**
     * Add a weapon to this Actor's inventory
     * @param weapon The weapon to be added
     */
    public void addWeaponToInventory(SellableItem weapon) {
        sellableWeaponInventory.add(weapon);
    }

    /**
     * Remove a weapon from this Actor's inventory
     * @param weapon The weapon to be removed
     */
    public void removeWeaponFromInventory(SellableItem weapon) {
        sellableWeaponInventory.remove(weapon);
    }
}
