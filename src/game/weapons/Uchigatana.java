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
import game.utils.RandomNumberGenerator;
import game.weaponabilities.Unsheathe;

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
public class Uchigatana extends WeaponItem implements PurchasableItem, SellableItem, Unsheathe {
    private Actor actor;
    private ActionList allowableActions;

    /**
     * Constructor
     */

    public Uchigatana() {
        super("Uchigatana", ')', 115, "slashes", 80);
        this.allowableActions = new ActionList();
    }


    public int getPurchasePrice() {
        int purchasePrice = 5000;
        return purchasePrice;
    }

    public int getSellingPrice() {
        int sellingPrice = 500;
        return sellingPrice;
    }
    public int unsheathe(){
        int newDamage = super.damage();

        if(RandomNumberGenerator.getRandomInt(100) <= 60){
            newDamage = newDamage*2;
        }
        return newDamage;

    }
//    public Action getSkill(Actor holder) {
//        return
//    }


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
            if (destination.getDisplayChar() == 'K' && this.allowableActions.size() == 0) {
                this.allowableActions.add(new SellAction(actor, this, this));
                counter++;
            } else if (this.allowableActions.size() != 0 && counter == 0) {
                this.allowableActions.clear();

            }

        }
    }
}
