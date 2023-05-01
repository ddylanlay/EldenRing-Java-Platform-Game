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
    ActionList actions = new ActionList();
    Map map;
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
    public void tick(Location currentLocation, Actor actor) {
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.getDisplayChar() == 'K') {
                actions.add(new SellAction(actor, this, this));
            }
        }
    }
    @Override
    public List<Action> getAllowableActions() {
        this.addCapability(WeaponType.SELLABLE);
        return super.getAllowableActions();
    }


}
