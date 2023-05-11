package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actionsgame.SellAction;
import game.actionsgame.SpinAttackActionGrossmesser;
import game.trading.SellableItem;
import game.trading.TradingCapability;

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
public class Grossmesser extends WeaponItem implements SellableItem{
    private ActionList allowableActions;
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

    public int spinAttack(){
        return 0;
    }

    @Override
    public List<Action> getAllowableActions() {

        this.allowableActions.add(new SpinAttackActionGrossmesser(this));
        return this.allowableActions.getUnmodifiableActionList();
    }
    @Override
    public void tick(Location currentLocation, Actor actor) {
        int counter = 0;
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if ((destination.containsAnActor() && destination.getActor().hasCapability(TradingCapability.TRADE)) && this.allowableActions.size() == 0) {
                this.allowableActions.add(new SellAction(actor, this, this));
                counter++;

            }
            else if(this.allowableActions.size() != 0 && counter == 0){
                this.allowableActions.clear();

            }
        }
    }
}
