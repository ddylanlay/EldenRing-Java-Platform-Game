package game.trading;

import edu.monash.fit2099.engine.actors.Actor;

public interface PurchasableItem {
    int getPurchasePrice();

    void addWeaponToActor(Actor actor);
}
