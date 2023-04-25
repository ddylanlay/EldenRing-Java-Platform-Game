package game.combatclass;

import game.weapons.Club;

/**
 * The Wretch combat class, with starting health 414 and Club starting weapon.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class Wretch extends CombatClass {

//    /**
//     * Constructor
//     */
//    public Wretch(){ super(414, new Club()); }
    public Wretch(){
        super("Wretch", 'w', 414);
        this.addWeaponToInventory(new Club());
    }
    public String toString(){
        return name;
    }

}
