package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Player;
import game.combatclass.CombatClass;
import game.trading.SellableItem;
import game.weapons.SellableWeaponInventory;

public class SelectCombatClassAction extends Action {

    private CombatClass combatClass;
    private Player player;
    private SellableWeaponInventory sellableWeaponInventory = SellableWeaponInventory.getInstance();

    public CombatClass getCombatClass() { return combatClass; }

    public SelectCombatClassAction(CombatClass _combatClass, Player _player){
        this.combatClass = _combatClass;
        this.player = _player;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        WeaponItem newWeapon = combatClass.getClassWeapon();
        SellableItem newWeapon1 = combatClass.getClassWeapon1();
        int maxHealth = combatClass.getMaxHitPoints();
        actor.addWeaponToInventory(newWeapon);
        sellableWeaponInventory.addWeaponToInventory(newWeapon1);
        actor.resetMaxHp(maxHealth);
        player.setCombatClass(combatClass);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {

        String result = "The combat class " + combatClass.getClassName() + " was selected.";
        return result;
    }


}
