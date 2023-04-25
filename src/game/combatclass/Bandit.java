package game.combatclass;

import game.weapons.GreatKnife;

/**
 * The Bandit combat class, with starting health 414 and Great Knife starting weapon.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class Bandit extends CombatClass {

    /**
     * Constructor
     */
//    public Bandit()
//    { super(414, new GreatKnife()); }
    public Bandit(){
        super("Bandit", 'b', 414);
        this.addWeaponToInventory(new GreatKnife());
    }
    public String toString(){
        return name;
    }

}
