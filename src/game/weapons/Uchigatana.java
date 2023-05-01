package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actionsgame.SellAction;
import game.trading.PurchasableItem;
import game.trading.SellableItem;

import java.util.List;

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
    private Actor actor;
    ActionList actions = new ActionList();
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
    @Override
    public List<Action> getAllowableActions() {
        this.addCapability(WeaponType.SELLABLE);
        return super.getAllowableActions();
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.getDisplayChar() == 'K') {
                actions.add(new SellAction(actor, this, this));
            }
        }
    }
}
