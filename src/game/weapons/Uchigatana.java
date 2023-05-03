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
    private Actor target;
    private String direction;
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
//    public int unsheathe(Actor target){
//        int newDamage = 0;
//
//        if(RandomNumberGenerator.getRandomInt(100) <= 60){
//            newDamage = super.damage()*2;
//            return newDamage;
//        }
//        return newDamage;
//    }

//    @Override
//    public Action getSkill(Actor target, String direction){
//         return new UnsheatheAttackAction(target, direction,this);
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
                this.allowableActions.remove(new SellAction(actor, this, this));

            }

        }
    }
}
