package game.trading;

import edu.monash.fit2099.engine.actors.Actor;

public interface SellableItem {
    int getSellingPrice();
    void removeWeaponToActor(Actor actor);

}
