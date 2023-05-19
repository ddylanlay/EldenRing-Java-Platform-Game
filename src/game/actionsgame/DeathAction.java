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
import game.trading.OLD_Runes;
import game.trading.RunesManager;
import game.items.Runes;

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

    /**
     * Unused, the actor that did the attacking.
     */
    private Actor attacker;

    /**
     * Location of the attack.
     */
    Location location;

    /**
     * Unused, previous location of actors.
     */
    private Location previousLocation;

    /**
     * Unused, the runes.
     */
    OLD_Runes OLDRunes;

    /**
     * Runes Manager, to deal with runes exchange.
     */
    RunesManager runesManager = RunesManager.getInstance();

    /**
     * Reset Manager to deal with resetting map.
     */
    ResetManager resetManager = ResetManager.getInstance();

    /**
     * Constructor.
     *
     * @param actor the attacker.
     */
    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    public DeathAction(Actor actor, Location previousLocation) {
        this.attacker = actor;
        this.previousLocation = previousLocation;
    }


    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map    The map the actor is on.
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
        } else {
            // NEEDS TO BE PREVIOUS LOCATION BEFORE DEATH

            System.out.println(FancyMessage.YOU_DIED);
            if (previousLocation == null) {
                previousLocation = map.locationOf(target);
            }
            if (runesManager.retrieveActorsRunes(target) != 0) {
                Runes deathRunes = new Runes(runesManager.retrieveActorsRunes(target));
                runesManager.removeRunes(target, deathRunes.getValue()); //Remove runes from player
                map.at(previousLocation.x(), previousLocation.y()).addItem(deathRunes); //Drop item on the ground
            }
            resetManager.run(map);
        }

        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    /**
     * Menu Description of what is occuring.
     *
     * @param actor The actor performing the action.
     * @return menu description string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
