package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.items.FlaskOfCrimsonTears;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class ResetManager {
    private Map<Actor, Resettable> resettables;
    private static ResetManager instance;


    /**
     * HINT 1: where have we seen a private constructor before?  [WHEN WE WANT ONLY ONE INSTANCE OF A CLASS]
     * HINT 2: see the instance attribute above.
     */
    private ResetManager() { this.resettables = new HashMap<>(); }


    public static ResetManager getInstance(){
        if(instance == null) {
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     *
     */
    public void run(GameMap gameMap) {

        Set<Entry<Actor, Resettable>> entrySet = resettables.entrySet();
        Iterator<Entry<Actor, Resettable>> iter = entrySet.iterator();

        while (iter.hasNext()){

            Entry<Actor, Resettable> entry = iter.next();
            Actor actor = entry.getKey();
            Resettable resettable = entry.getValue();

            //Do the reset for resettable instance
            resettable.reset(gameMap);

            //If not the player
            if (!resettable.isPlayer()) {

                //Remove them from the resettables list
                iter.remove();
            }

        }

//        for (Map.Entry<Actor, Resettable> item : resettables.entrySet()){
//
//            //Get the actor and resettable objects
//            Actor actor = item.getKey();
//            Resettable resettable = item.getValue();
//
//            //If not the player
//            if (resettable.isPlayer()) {
//
//                //Remove them from the resettables list
////                removeResettable(actor);
//                myPlayerA = actor;
//                myPlayerR = resettable;
//            }
//
//            //Do the reset for resettable instance
//            resettable.reset(gameMap);
//        }


        FlaskOfCrimsonTears bottle = FlaskOfCrimsonTears.getInstance();
        bottle.reset(gameMap);
    }

    /**
     *
     * @param actor
     * @param resettable
     */
    public void registerResettable(Actor actor, Resettable resettable) { resettables.put(actor, resettable); }

    /**
     *
     * @param actor
     */
    public void removeResettable(Actor actor) { resettables.remove(actor); }

    /**
     *
     * @param actor
     * @param locationOfSite
     */
    public void updatePlayerSiteLocation(Actor actor, Location locationOfSite){

        Resettable player = resettables.get(actor);
        player.setLastSiteOfGrace(locationOfSite);
    }

}
