package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Player;
import game.actionsgame.SellAction;
import game.trading.PurchasableItem;
import game.trading.SellableItem;
import game.trading.TradingCapability;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private ArrayList<Actor> actorInRange = new ArrayList<>();
    private Actor actor;
    private Player player;
    private ActionList allowableActions;
    Map map;
    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
        this.allowableActions = new ActionList();
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
//        if(counter == 0 && this.allowableActions.size() != 0){
//            this.allowableActions.clear();
//        }
    }
    @Override
    public List<Action> getAllowableActions() {
        this.addCapability(WeaponType.HAMMER);
        return this.allowableActions.getUnmodifiableActionList();
    }

    public void addWeaponToActor(Actor actor){
        actor.addWeaponToInventory(this);
    }
    public void removeWeaponToActor(Actor actor){
        actor.removeWeaponFromInventory(this);
    }



}
