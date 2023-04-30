package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actionsgame.SellAction;
import game.trading.PurchasableItem;
import game.trading.SellableItem;

import java.util.List;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 *
 * Created by:
 * @author Adrian Kristanto
 *
 * Modified by:
 * @author Arosh Heenkenda
 */
public class Club extends WeaponItem implements PurchasableItem, SellableItem {
    private Actor actor;
    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

    public int getPurchasePrice(){
        int purchasePrice = 600;
        return purchasePrice;
    }

    public int getSellingPrice(){
        int sellingPrice = 100;
        return sellingPrice;
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}
    @Override
    public List<Action> getAllowableActions() {
        ActionList actions = new ActionList();
        actions.add(new SellAction(actor, this, this));
        this.addCapability(WeaponType.SELLABLE);
        return super.getAllowableActions();
    }
}
