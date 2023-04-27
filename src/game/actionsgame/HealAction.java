package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;

/**
 *
 */
public class HealAction extends Action {

    final int HEALTH_INCREASE = 250;
    private Player player;

//    /**
//     *
//     * @param target
//     * @param healthIncrease
//     */
//    public HealAction(Actor _target, int _healthIncrease){
//
//        this.target = _target;
//        this.healIncrease = _healthIncrease;
//
//    }
    public String heal(Player player){
        player.heal(HEALTH_INCREASE);
        player.bottle.consume();
        return theMenuDescription(player);
    }
    @Override
    public String execute(Actor actor, GameMap map) {
       return heal((Player) actor);
    }

    public String theMenuDescription(Player player){
        String result = player + " consumes " + player.bottle.toString() + " (" + player.bottle.remainingUses + "/" + player.bottle.MAX_USES + ").";
        return result;
    }
    @Override
    public String menuDescription(Actor actor) {
        return theMenuDescription((Player) actor);
    }
}
