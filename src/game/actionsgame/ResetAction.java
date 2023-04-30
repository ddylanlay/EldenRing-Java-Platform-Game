package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import static game.FancyMessage.YOU_DIED;

public class ResetAction extends Action {
    private Location location;
    ResetManager resetManager = ResetManager.getInstance();

    public ResetAction(Location location){
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map){
        map.moveActor(actor, location);
        resetManager.run(map);
        return YOU_DIED;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
