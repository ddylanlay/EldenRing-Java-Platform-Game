package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actionsgame.SellAction;
import game.trading.SellableItem;

import java.util.List;

/**
 * A curved sword that both enemies and player can use to attack.
 * It deals 115 damage with 85% hit rate
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class Grossmesser extends WeaponItem implements SellableItem {
    /**
     * Constructor
     */
    public Grossmesser(){
        super("Grossmesser", '?', 115, "slashes", 85);


    }
    public int getSellingPrice(){
        int sellingPrice = 100;
        return sellingPrice;
    }
    @Override
    public List<Action> getAllowableActions() {
        this.addCapability(WeaponType.SELLABLE);
        return super.getAllowableActions();
    }
    @Override
    public void tick(Location currentLocation, Actor actor) {
        ActionList actions = new ActionList();
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.getDisplayChar() == 'K') {
                actions.add(new SellAction(actor, this, this));
            }
        }
    }
}
