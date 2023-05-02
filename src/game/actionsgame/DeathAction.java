package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.FancyMessage;
import game.ResetManager;
import game.trading.Runes;
import game.trading.RunesManager;

/**
 * An action executed if an actor is killed.
 *
 * Created by:
 * @author Adrian Kristanto
 *
 * Modified by:
 * @author Arosh Heenkenda
 * @author Dylan Lay
 *
 */
public class DeathAction extends Action {
    private Actor attacker;
    Location location;
    private Location previousLocation;
    Runes runes;
    RunesManager runesManager = RunesManager.getInstance();
    ResetManager resetManager = ResetManager.getInstance();

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";
        ActionList dropActions = new ActionList();
        // drop all items
        if (target.getDisplayChar() != '@') {
            for (Item item : target.getItemInventory())
                dropActions.add(item.getDropAction(target));
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
            resetManager.removeResettable(target);
            map.removeActor(target);
        }
        else {
            // NEEDS TO BE PREVIOUS LOCATION BEFORE DEATH
            resetManager.run(map);
            System.out.println(FancyMessage.YOU_DIED);
            location = map.locationOf(target);
            location.setGround(new Runes(target, location.getGround()));


        }
        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
