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
 * A knife weapon that can be used to attack the enemy.
 * It deals 75 damage with 70% hit rate
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class GreatKnife extends WeaponItem implements PurchasableItem, SellableItem {
    private Actor actor;
    private ActionList allowableActions;
    /**
     * Constructor
     */
    public GreatKnife(){
        super("Great Knife", '/', 75, "slashes", 70);
        this.allowableActions = new ActionList();
    }


    public void tick(Location currentLocation, Actor actor) {
        this.allowableActions.add(new SellAction(actor, this, this));
    }
    @Override
    public List<Action> getAllowableActions() {
        ActionList actions = new ActionList();
        actions.add(new SellAction(actor, this, this));
        this.addCapability(WeaponType.SELLABLE);
        return super.getAllowableActions();
    }

    public int getPurchasePrice(){
        int purchasePrice = 3500;
        return purchasePrice;
    }
    public int getSellingPrice(){
        int sellingPrice = 350;
        return sellingPrice;
    }
}
