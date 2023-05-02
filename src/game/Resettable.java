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

    /*

     */
    void reset(GameMap gameMap);

    /**
     *
     * @return
     */
    boolean isPlayer();

    /**
     *
     * @param lastSiteOfGrace
     */
    void setLastSiteOfGrace(Location lastSiteOfGrace);
}
