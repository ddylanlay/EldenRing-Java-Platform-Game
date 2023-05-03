package game.combatclass;

import game.weapons.Uchigatana;

/**
 * The Samurai Combat class, with starting health 455 and Uchigatana starting weapon.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class Samurai extends CombatClass {

    /**
     * Constructor
     */
    public Samurai(){
        super("Samurai", 's', 9999999, new Uchigatana());//455
    }

}
