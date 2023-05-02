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
import game.weaponabilities.SpinAttack;

import java.util.List;

/**
 * A curved sword that both enemies and player can use to attack.
 * It deals 118 damage with 88% hit rate
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 * @author Jamie Tran
 *
 */
public class Scimitar extends WeaponItem implements SpinAttack, PurchasableItem, SellableItem {
    private ActionList allowableActions;
    /**
     * Constructor
     */
    public Scimitar() { super("Scimitar", 's', 118, "slashes", 88);
        this.allowableActions = new ActionList();}

    public int getPurchasePrice(){
        int purchasePrice = 600;
        return purchasePrice;
    }
    public int getSellingPrice(){
        int sellingPrice = 100;
        return sellingPrice;
    }
    @Override
    public void tick(Location currentLocation, Actor actor) {
        int counter = 0;
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.getDisplayChar() == 'K'&& this.allowableActions.size() == 0) {
                this.allowableActions.add(new SellAction(actor, this, this));
                counter ++;
            }
            else if(this.allowableActions.size() != 0 && counter == 0){
                this.allowableActions.clear();

            }

        }
    }
    @Override
    public List<Action> getAllowableActions() {
        this.addCapability(WeaponType.SELLABLE);
        return this.allowableActions.getUnmodifiableActionList();
    }
    @Override
    public void spinAttack() {

    }

}
