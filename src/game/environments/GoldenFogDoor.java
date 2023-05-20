package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;

public class GoldenFogDoor extends Ground {
    private Location destination;
    private String name;

    /**
     * Constructor.
     *
     * character to display for this type of terrain
     *
     */
    public GoldenFogDoor(String name, Location destination) {
        super('D');
        this.name = name;
        this.destination = destination;


    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = super.allowableActions(actor, location, direction);
        if(location.containsAnActor() && actor.hasCapability(Status.FAST_TRAVEL))
        {

            actions.add(new MoveActorAction(destination, name));
            return actions;
        }
        return super.allowableActions(actor, location, direction);
    }
}
