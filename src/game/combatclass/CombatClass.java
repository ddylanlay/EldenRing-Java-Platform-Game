package game.combatclass;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.trading.SellableItem;

/**
 * An abstract combat class used to initialise concrete combat classes
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 * @author Dylan Lay
 *
 */
public abstract class CombatClass {


    /**
     * The max health for a given combat class.
     */
    private int maxHitPoints;

    /**
     * The starting weapon for a given combat class.
     */
    private WeaponItem classWeapon;

    /**
     * The class name of the combat class.
     */
    private String className;

    /**
     * The display character for the combat class.
     */
    private char displayChar;

    private SellableItem classWeapon1;


    /**
     * Constructor
     *
     * @param _maxHitPoints the max hit points for a combat class.
     * @param _classWeapon the starting weapon for a combat class.
     * @param _className the name of the combat class.
     * @param _displayChar the displayCharacter for printing the combat class.
     */
    public CombatClass(String _className, char _displayChar, int _maxHitPoints, WeaponItem _classWeapon){

        this.maxHitPoints = _maxHitPoints;
        this.classWeapon = _classWeapon;
        this.className = _className;
        this.displayChar = _displayChar;
    }

    /**
     * Getter for the max hit points.
     *
     * @return integer representing max hit points.
     */
    public int getMaxHitPoints() { return maxHitPoints; }

    /**
     * Getter for the class weapon.
     *
     * @return WeaponItem instance, weapon of the associated class.
     */
    public WeaponItem getClassWeapon() { return classWeapon; }

    /**
     * Getter for class name.
     *
     * @return String representing the class name.
     */
    public String getClassName() { return className; }

    /**
     * Getter for the display character.
     *
     * @return Char representing character name.
     */
    public char getDisplayChar() { return displayChar; }
    public SellableItem getClassWeapon1() {
        return classWeapon1;
    }



    /**
     * To String method
     *
     * @return A formatted string.
     */
    @Override
    public String toString(){ return className; }



//    public CombatClass(String name, char displayChar, int hitPoints){
//        super(name, displayChar, hitPoints);
//    }
//    public String toString(){
//        return "the One";
//    }
//
//
//    @Override
//    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
//        ActionList actions = super.allowableActions(otherActor, direction, map);
//        actions.add(new SelectCombatClassAction(new Bandit()));
//        actions.add(new SelectCombatClassAction(new Samurai()));
//        actions.add(new SelectCombatClassAction(new Wretch()));
//        return actions;
//    }
//
//    @Override
//    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
//        // Handle multi-turn Actions
//        if (lastAction.getNextAction() != null)
//            return lastAction.getNextAction();
//        System.out.println("Select your role:");
//        // return/print the console menu
//        return combatClassMenu.showMenu(this, actions, display);
//    }

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
