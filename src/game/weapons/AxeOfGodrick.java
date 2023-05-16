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
 * Axe of Godrick weapon, only obtainable by trading a Remembrance of Grafted from Enia.
 *
 * Deals 142 damage with an 84% hit rate.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class AxeOfGodrick extends WeaponItem implements SellableItem {

    /**
     * Allowable actions for Axe of Godrick
     */
    private ActionList allowableActions;
    private Actor actor;

    /**
     * Constructor.
     *
     */
    public AxeOfGodrick() {

        super("Axe of Godrick", 'T', 142, "swing", 84);
        this.allowableActions = new ActionList();
    }

    /**
     * Selling price of Axe of Godrick.
     *
     * @return an integer representing the price.
     */
    @Override
    public int getSellingPrice() {
        int sellingPrice = 100;
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
                this.allowableActions.add(new SellAction(actor,  this));
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
