package game;

import edu.monash.fit2099.engine.positions.GameMap;

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
    void reset(GameMap gameMap);

    boolean isPlayer();
}
