package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A curved sword that both enemies and player can use to attack.
 * It deals 118 damage with 88% hit rate
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class Scimitar extends WeaponItem {

    /**
     * Constructor
     */
    public Scimitar() { super("Scimitar", 's', 118, "slashes", 88); }
}
