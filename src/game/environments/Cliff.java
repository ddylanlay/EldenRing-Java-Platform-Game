package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Cliff extends Ground {


    /**
     * Constructor.
     *
     *
     * */
    public Cliff() {
        super('+');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        boolean isPlayer = false;
        if (actor.getDisplayChar() == '@'){
            isPlayer = true;
        }
        return isPlayer;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        String result = "";
        if (location.getActor() == actor)
        {
            actor.hurt(Integer.MAX_VALUE);
            if(!actor.isConscious()){
                ActionList actions = super.allowableActions(actor, location, direction);
                return actions;
            }
        }
        return super.allowableActions(actor, location, direction);
    }
}
