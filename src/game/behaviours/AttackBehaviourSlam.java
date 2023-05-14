package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actionsgame.AttackAction;
import game.actionsgame.AttackActionIntrinsic;
import game.actionsgame.SlamAttackAction;
import game.utils.RandomNumberGenerator;

/**
 * @author Jamie Tran
 */
public class AttackBehaviourSlam extends Action implements Behaviour{
    private Actor target;
    public AttackBehaviourSlam(Actor target){
        this.target = target;
    }
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location actorPosition = map.locationOf(actor);
        Location targetPosition = map.locationOf(target);
        int distance = distance(actorPosition, targetPosition);
        if(distance == 1){
            if(RandomNumberGenerator.getRandomInt(100)<= 50) {
                return new AttackActionIntrinsic(target, "to the enemy");
            }
            else{
                return new SlamAttackAction(actor);
            }
        }
        return null;
    }
    public String execute(Actor actor, GameMap map){
        return menuDescription(actor);
    }

    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }

    public String menuDescription(Actor actor){
        return "AttackBehaviour";
    }

}
