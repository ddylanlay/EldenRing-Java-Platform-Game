package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actionsgame.SellAction;
import game.trading.SellableItem;
import game.trading.TradingCapability;

import java.util.List;

/**
 * Grafted Dragon weapon, only obtainable by trading a Remembrance of Grafted from Enia.
 *
 * Deals 89 damage with a 90% hit rate.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class GraftedDragon extends WeaponItem implements SellableItem {

    /**
     * Allowable actions for Axe of Godrick
     */
    private ActionList allowableActions;

    /**
     * Constructor.
     *
     */
    public GraftedDragon() {

        super("Grafted Dragon", 'N', 89, "bite", 90);
        this.allowableActions = new ActionList();
    }

    /**
     * Selling price of the Grafted Dragon.
     *
     * @return an integer representing its selling price.
     */
    @Override
    public int getSellingPrice() {
        int sellingPrice = 200;
        return sellingPrice;
    }

    /**
     * Stuff that happens every game tick.
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        int counter = 0;
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if ((destination.containsAnActor() && destination.getActor().hasCapability(TradingCapability.TRADE)) && this.allowableActions.size() == 0) {
                this.allowableActions.add(new SellAction(actor, this));
                counter ++;
            }
            else if(this.allowableActions.size() != 0 && counter == 0){
                this.allowableActions.clear();

            }
        }
    }

    /**
     * Get allowable actions of item.
     *
     * @return an allowable actions list, unmodifable.
     */
    @Override
    public List<Action> getAllowableActions() { return this.allowableActions.getUnmodifiableActionList(); }


    public void removeWeaponToActor(Actor actor){
        actor.removeWeaponFromInventory(this);
    }

}
