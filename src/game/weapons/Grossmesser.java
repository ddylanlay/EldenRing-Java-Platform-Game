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
    private ActionList allowableActions;
    ActionList actions = new ActionList();
    /**
     * Constructor
     */
    public Grossmesser(){
        super("Grossmesser", '?', 115, "slashes", 85);
        this.allowableActions = new ActionList();


    }
    public int getSellingPrice(){
        int sellingPrice = 100;
        return sellingPrice;
    }
    @Override
    public List<Action> getAllowableActions() {
        return this.allowableActions.getUnmodifiableActionList();
    }
    @Override
    public void tick(Location currentLocation, Actor actor) {
        int counter = 0;
        ActionList actions = new ActionList();
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.getDisplayChar() == 'K'&& this.allowableActions.size() == 0) {
                this.allowableActions.add(new SellAction(actor, this, this));
                counter++;

            }
            else if(this.allowableActions.size() != 0 && counter == 0){
                this.allowableActions.clear();

            }
        }
    }
}
