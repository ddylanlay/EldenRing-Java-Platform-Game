package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A katana weapon that can be used to attack the enemy.
 * It deals 115 damage with 80% hit rate
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class Uchigatana extends WeaponItem {

    /**
     * Constructor
     */
    public Uchigatana(){ super("Uchigatana", ')', 115, "slashes", 80); }

}
