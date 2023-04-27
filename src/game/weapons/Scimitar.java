package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.RandomNumberGenerator;
import game.weaponabilities.SpinAttack;

import java.util.ArrayList;

/**
 * A curved sword that both enemies and player can use to attack.
 * It deals 118 damage with 88% hit rate
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 * @author Jamie Tran
 *
 */
public class Scimitar extends WeaponItem implements SpinAttack {
    /**
     * Constructor
     */
    public Scimitar() { super("Scimitar", 's', 118, "slashes", 88); }

    @Override
    public void spinAttack() {

    }
}
