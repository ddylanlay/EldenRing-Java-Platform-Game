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

    public Wretch(){
        super("Wretch", 'w', 414, new Club(), new Club());
    }

}
