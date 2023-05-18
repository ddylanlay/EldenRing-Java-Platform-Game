package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actionsgame.AttackAction;
import game.actionsgame.QuickstepAttackAction;
import game.actionsgame.SpinAttackActionScimitar;
import game.actionsgame.UnsheatheAttackAction;
import game.utils.RandomNumberGenerator;
import game.weapons.WeaponType;

import java.util.List;
import java.util.Random;

/**
 * @author Jamie Tran
 */
public class AttackBehaviour extends Action implements Behaviour{
    private Actor target;
    public AttackBehaviour(Actor target){
        this.target = target;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location actorPosition = map.locationOf(actor);
        Location targetPosition = map.locationOf(target);

        int distance = distance(actorPosition, targetPosition);

        if(distance == 1){

            return new AttackAction(target, "to the enemy");

        }
        return null;
    }
    public String execute(Actor actor, GameMap map){
        return menuDescription(actor);
    }

    private int distance(Location a, Location b) {
        if (b == null || a == null) {
            return -1;
        } else {
            return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
        }
    }

    public String menuDescription(Actor actor){
        return "AttackBehaviour";
    }

}
