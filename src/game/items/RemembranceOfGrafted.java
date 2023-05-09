package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.actionsgame.SellAction;
import game.actionsgame.TradeGraftedAction;
import game.trading.TradingCapability;
import game.weapons.WeaponType;

import java.util.List;

/**
 * Remembrance of the Grafted Item
 *
 * Allows player to trade for Axe of Godrick or Grafted Dragon from Enia.
 */
public class RemembranceOfGrafted extends Item {

    private ActionList allowableActions;

    /***
     * Constructor.
     *
     */
    public RemembranceOfGrafted() {
        super("Remembrance of the Grafted", 'O', true);
        this.allowableActions = new ActionList();
    }

    /**
     * Game tick function.
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor){

        this.allowableActions.clear();

        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if ((destination.containsAnActor() && destination.getActor().hasCapability(TradingCapability.GRAFTED_TRADE)) && this.allowableActions.size() == 0) {
                this.allowableActions.add(new TradeGraftedAction(this));
            }
        }
    }

    /**
     * Get allowable actions for the item.
     *
     * @return an unmodifiable list of item actions.
     */
    @Override
    public List<Action> getAllowableActions() { return this.allowableActions.getUnmodifiableActionList(); }

    /**
     * Create and return an action to drop this Item.
     * If this Item is not portable, returns null.
     *
     * @return a new DropItemAction if this Item is portable, null otherwise.
     */
    @Override
    public DropAction getDropAction(Actor actor) {
        this.allowableActions.clear();
        if(portable)
            return new DropItemAction(this);
        return null;
    }
}
