package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class WanderBehaviour implements Behaviour {
	
	private final Random random = new Random();

	/**
	 * Returns a MoveAction to wander to a random location, if possible.  
	 * If no movement is possible, returns null.
	 * 
	 * @param actor the Actor enacting the behaviour
	 * @param map the map that actor is currently on
	 * @return an Action, or null if no MoveAction is possible
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		ArrayList<Action> actions = new ArrayList<>();
		
		for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
			// determines which direction the NPC should go in
            if (destination.canActorEnter(actor)) {
				// checks each exit to see which directions NPC can go in, if it can go in a particular direction, it gets added to the list of possible move actions
            	actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));
            }
        }
		
		if (!actions.isEmpty()) {
			// chooses one action randomly out of possible moves
			return actions.get(random.nextInt(actions.size()));
		}
		else {
			// if no possible moves available
			return null;
		}

	}
}
