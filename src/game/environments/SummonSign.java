package game.environments;

import edu.monash.fit2099.demo.conwayslife.Player;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actionsgame.SpawnAction;

public class SummonSign extends Ground {
    private Player player;
    private EnemiesFactory enemiesFactory;
    public SummonSign(EnemiesFactory enemiesFactory){
        super('=');
        this.enemiesFactory = enemiesFactory;
    }
    public void tick(Location spawnLocation){
//        if(!spawnLocation.containsAnActor()){
//            this.enemiesFactory.spawnSkeleton(spawnLocation);
//        }

    }
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = super.allowableActions(actor, location, direction);
        if(actor.hasCapability(Status.SPAWN)){
            actions.add(new SpawnAction(location));
        }
        return actions;

    }


}