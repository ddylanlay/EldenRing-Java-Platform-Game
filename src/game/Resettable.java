package game;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A resettable interface
 *
 * Created by:
 * @author Adrian Kristanto
 *
 * Modified by:
 * @author Arosh Heenkenda
 *
 */
public interface Resettable {

    /**
     *
     * @param gameMap the map with of the game
     *
     */
    void reset(GameMap gameMap);

    /**
     *
     * @return boolean true or false
     */
    boolean isPlayer();

    /**
     *
     * @param lastSiteOfGrace the most recent site that the player rested on
     *
     */
    void setLastSiteOfGrace(Location lastSiteOfGrace);
}
