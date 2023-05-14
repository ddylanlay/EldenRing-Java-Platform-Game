package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.*;
import game.utils.RandomNumberGenerator;

/**
 * Spawn enemies unique to east side of the map.
 *
 * Created by:
 * @author Jamie Tran
 *
 * Modified by:
 * @author Arosh Heenkenda
 *
 */
public class SouthFactory implements EnemiesFactory {

    @Override
    public void spawnCanis(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 33) {
            location.addActor(new Borzoi());
        }
    }

    @Override
    public void spawnSkeleton(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 27) {
            location.addActor(new Madara());
        }
    }

    @Override
    public void spawnCrustacean(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 2) {
            location.addActor(new GiantCrayfish());
        }
    }


}
