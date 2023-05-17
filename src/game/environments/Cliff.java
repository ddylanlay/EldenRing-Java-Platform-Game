package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Cliff extends Ground {


    /**
     * Constructor for cliff
     *
     *
     * */
    public Cliff() {
        super('+');
    }

    /**
     * Checks if the actor is the player
     *
     * @param actor the specific actor

     * @return true or false whether it is the player or not
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        boolean isPlayer = false;
        if (actor.getDisplayChar() == '@'){
            isPlayer = true;
        }
        return isPlayer;
    }
    /**
     * The actions that can be done interacting with the cliff
     *
     *  @param actor the Actor that might be interacting with the cliff
     *  @param location  location of the cliff
     *  @param direction  String representing the direction of the other Actor
     *  @return actions
     *
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
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
