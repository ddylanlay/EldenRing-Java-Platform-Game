package game.combatclass;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * An abstract combat class used to initialise concrete combat classes
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public abstract class CombatClass {

    /**
     * The max health for a given combat class.
     */
    private final int maxHitPoints;

    /**
     * The starting weapon for a given combat class.
     */
    private final WeaponItem classWeapon;

    /**
     * Constructor
     *
     * @param _maxHitPoints the max hit points for a combat class.
     * @param _classWeapon the starting weapon for a combat class.
     */
    public CombatClass(int _maxHitPoints, WeaponItem _classWeapon){

        this.maxHitPoints = _maxHitPoints;
        this.classWeapon = _classWeapon;
    }

    /**
     * Getter for maxHitPoints
     *
     * @return an int value for the max hit points of a combat class.
     */
    public int getMaxHitPoints() { return maxHitPoints; }

    /**
     * Getter for classWeapon
     *
     * @return an object of WeaponItem for the weapon of a combat class
     */
    public WeaponItem getClassWeapon() { return classWeapon;}

}
