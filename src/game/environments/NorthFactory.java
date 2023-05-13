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
public class NorthFactory implements EnemiesFactory {

    @Override
    public void spawnCanis(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 75) {
            location.addActor(new RaccoonDog());
        }
    }

    @Override
    public void spawnSkeleton(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 10) {
            location.addActor(new Gashadokuro());
        }
    }

    @Override
    public void spawnCrustacean(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 15) {
            location.addActor(new SpiderCrab());
        }
    }


}
