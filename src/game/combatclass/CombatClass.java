package game.combatclass;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actionsgame.SelectCombatClassAction;

/**
 * An abstract combat class used to initialise concrete combat classes
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class CombatClass extends Actor {
    private final CombatClassMenu combatClassMenu = new CombatClassMenu();

//    /**
//     * The max health for a given combat class.
//     */
//    private final int maxHitPoints;
//
//    /**
//     * The starting weapon for a given combat class.
//     */
//    private final WeaponItem classWeapon;
//
//    /**
//     * Constructor
//     *
//     * @param _maxHitPoints the max hit points for a combat class.
//     * @param _classWeapon the starting weapon for a combat class.
//     */
//    public CombatClass(int _maxHitPoints, WeaponItem _classWeapon){
//
//        this.maxHitPoints = _maxHitPoints;
//        this.classWeapon = _classWeapon;
//    }

    public CombatClass(String name, char displayChar, int hitPoints){
        super(name, displayChar, hitPoints);
    }
    public String toString(){
        return "the One";
    }


    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        actions.add(new SelectCombatClassAction(new Bandit()));
        actions.add(new SelectCombatClassAction(new Samurai()));
        actions.add(new SelectCombatClassAction(new Wretch()));
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();
        System.out.println("Select your role:");
        // return/print the console menu
        return combatClassMenu.showMenu(this, actions, display);
    }

//    /**
//     * Getter for maxHitPoints
//     *
//     * @return an int value for the max hit points of a combat class.
//     */
//    public int getMaxHitPoints() { return maxHitPoints; }
//
//    /**
//     * Getter for classWeapon
//     *
//     * @return an object of WeaponItem for the weapon of a combat class
//     */
//    public WeaponItem getClassWeapon() { return classWeapon;}

}
