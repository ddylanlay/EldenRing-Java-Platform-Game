package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.trading.RunesManager;
import game.utils.RandomNumberGenerator;

public class UnsheatheAttackAction extends Action{
    private Weapon weapon;
    private Actor target;
    private String direction;
    RunesManager runesManager = RunesManager.getInstance();

    public UnsheatheAttackAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }




    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        int damage;

        if (!(RandomNumberGenerator.getRandomInt(100) <= 60)) {
            return actor + " misses " + target + ".";
        }
        damage = weapon.damage() * 2;
        target.hurt(damage);
        result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        if (!target.isConscious()) {
            result += new DeathAction(actor).execute(target, map);
            if (actor.getDisplayChar() == '@' && target.getDisplayChar() != '@') {
                int numOfRunes = runesManager.transferRunes(target, actor);
                String string = target + " drops " + numOfRunes + " runes";
                result += System.lineSeparator() + string;
                return result;
            }
        }
        return menuDescription(actor);
    }


    public String menuDescription(Actor actor) {
        return actor + " unsheathes Uchigatana on " + target;
    }
}
