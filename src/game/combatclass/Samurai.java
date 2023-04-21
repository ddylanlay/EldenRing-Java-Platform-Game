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
    public Samurai(){ super(455, new Uchigatana()); }

}
