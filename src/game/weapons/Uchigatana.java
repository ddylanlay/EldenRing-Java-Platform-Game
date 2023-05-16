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
import game.trading.TradingCapability;

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

    private ActionList allowableActions;

    /**
     * Constructor
     */

    public Uchigatana() {
        super("Uchigatana", ')', 115, "slashes", 80);
        this.allowableActions = new ActionList();
        this.actor = actor;
    }

    @Override
    public char getDisplayChar(){
        return super.getDisplayChar();
    }
    public int getPurchasePrice() {
        int purchasePrice = 5000;
        return purchasePrice;
    }

    public int getSellingPrice() {
        int sellingPrice = 500;
        return sellingPrice;
    }


    @Override
    public List<Action> getAllowableActions() {
        this.addCapability(WeaponType.KATANA);
        return this.allowableActions.getUnmodifiableActionList();
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        int counter = 0;
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if ((destination.containsAnActor() && destination.getActor().hasCapability(TradingCapability.TRADE)) && this.allowableActions.size() == 0) {
                this.allowableActions.add(new SellAction(actor, this));
                counter++;
            } else if (this.allowableActions.size() != 0 && counter == 0) {
                this.allowableActions.clear();

            }

        }
    }
    public void addWeaponToActor(Actor actor){
        actor.addWeaponToInventory(this);
    }

    public void removeWeaponToActor(Actor actor){
        actor.removeWeaponFromInventory(this);
    }
}
