package game;

import edu.monash.fit2099.engine.positions.GameMap;
import game.items.FlaskOfCrimsonTears;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class ResetManager {
    private List<Resettable> resettables;
    private static ResetManager instance;


    /**
     * HINT 1: where have we seen a private constructor before?  [WHEN WE WANT ONLY ONE INSTANCE OF A CLASS]
     * HINT 2: see the instance attribute above.
     */
    private ResetManager() { this.resettables = new ArrayList<>(); }


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

        for (Resettable resettable : resettables){
            resettable.reset(gameMap);

            //If not the player remove from the resettable list
            if (!resettable.isPlayer()) {
                removeResettable(resettable);
            }
        }

        FlaskOfCrimsonTears bottle = FlaskOfCrimsonTears.getInstance();
        bottle.reset(gameMap);
    }

    /**
     *
     * @param resettable
     */
    public void registerResettable(Resettable resettable) { resettables.add(resettable); }

    /**
     *
     * @param resettable
     */
    public void removeResettable(Resettable resettable) { resettables.remove(resettable); }

}
