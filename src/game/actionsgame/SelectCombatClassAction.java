package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Player;
import game.combatclass.CombatClass;

public class SelectCombatClassAction extends Action {

    private CombatClass combatClass;
    private Player player;

    /**
     *
     * @return CombatClass specific class of chosen by player
     */
    public CombatClass getCombatClass() { return combatClass; }

    /**
     * Constructor
     * @param _combatClass specific class of chosen by player
     * @param _player the specific actor choosing the class
     */
    public SelectCombatClassAction(CombatClass _combatClass, Player _player){
        this.combatClass = _combatClass;
        this.player = _player;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string menuDescription
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        WeaponItem newWeapon = combatClass.getClassWeapon();

        int maxHealth = combatClass.getMaxHitPoints();
        actor.addWeaponToInventory(newWeapon);
        actor.resetMaxHp(maxHealth);
        player.setCombatClass(combatClass);
        return menuDescription(actor);
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return string output
     */
    @Override
    public String menuDescription(Actor actor) {

        String result = "The combat class " + combatClass.getClassName() + " was selected.";
        return result;
    }


}
