package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enemies.HeavySkeletalSwordsman;
import game.enemies.PilesOfBonesHSS;
import game.enemies.PilesOfBonesSB;
import game.trading.Runes;
import game.ResetManager;
import game.trading.RunesManager;

/**
 * An action executed if an actor is killed, Pile of Bones actor.
 *
 * Created by:
 * @author Adrian Kristanto
 *
 * Modified by:
 * @author Arosh Heenkenda
 * @author Dylan Lay
 *
 */
public class DeathActionPB extends Action {

    /**
     * The attacker actor.
     */
    private Actor attacker;

    /**
     * Unused, the runes.
     */
    Runes runes;

    /**
     * Runes manager, deals with rune exchange.
     */
    RunesManager runesManager = RunesManager.getInstance();

    /**
     * Reset manager, deals with game reset.
     */
    ResetManager resetManager = ResetManager.getInstance();

    /**
     * Constructor.
     *
     * @param actor the attacker.
     */
    public DeathActionPB(Actor actor) {
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
        spawnPileOfBones(target, map);
        for (Item item : target.getItemInventory())
            dropActions.add(item.getDropAction(target));
        for (Action drop : dropActions)
            drop.execute(target, map);
        if (target.getDisplayChar() == '@'){
            int runesDropped = runesManager.retrieveActorsRunes(target);
            //dropActions.add(runes.getDropAction(target));
            runesManager.storeActorsRunes(target, 0);

        }

        // remove actor if not player
        if (target.getDisplayChar() != '@') {
            resetManager.removeResettable(target);
            map.removeActor(target);
        }
        else {
            resetManager.run(map);
        }
        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    /**
     * Menu description of action.
     *
     * @param actor The actor performing the action.
     * @return menu description string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }

    /**
     * Spawns a Pile of Bones
     *
     * @param target the HSS to spawn a POB on.
     * @param map the game map.
     */
    public void spawnPileOfBones(Actor target, GameMap map) {
        Location currentLocation = map.locationOf(target);
        if(target.isConscious() == false){
            if(target instanceof HeavySkeletalSwordsman) {
                map.removeActor(target);
                map.addActor(new PilesOfBonesHSS(), currentLocation);
            }
            else{
                map.removeActor(target);
                map.addActor(new PilesOfBonesSB(), currentLocation);
            }

        }
    }
}
