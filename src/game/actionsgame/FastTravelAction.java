package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class FastTravelAction extends Action {
    private String name;
    private Location destination;
    public FastTravelAction(String name, Location destination) {
        this.name = name;
        this.destination = destination;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, destination);
        return actor + " fast travelled to " + name;
    }

    @Override
    public String menuDescription(Actor actor) {
       return "Fast travel to " + name;
    }
}
