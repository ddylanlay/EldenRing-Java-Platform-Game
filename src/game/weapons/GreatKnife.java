package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A knife weapon that can be used to attack the enemy.
 * It deals 75 damage with 70% hit rate
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class GreatKnife extends WeaponItem {

    /**
     * Constructor
     */
    public GreatKnife(){ super("Great Knife", '/', 75, "slashes", 70); }

}
