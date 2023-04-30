package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.enemies.*;
import game.utils.RandomNumberGenerator;

/**
 * Spawn enemies unique to west side of the map.
 *
 * Created by:
 * @author Jamie Tran
 *
 * Modified by:
 * @author Arosh Heenkenda
 *
 */
public class WestFactory implements EnemiesFactory {

    private ResetManager resetManager = ResetManager.getInstance();

    @Override
    public void spawnCanis(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 33) {

            LoneWolf loneWolf = new LoneWolf();
            resetManager.registerResettable(loneWolf, loneWolf);

            location.addActor(loneWolf);
        }
    }

    @Override
    public void spawnSkeleton(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 27) {

            HeavySkeletalSwordsman heavySkeletalSwordsman = new HeavySkeletalSwordsman();
            resetManager.registerResettable(heavySkeletalSwordsman, heavySkeletalSwordsman);

            location.addActor(heavySkeletalSwordsman);
        }
    }

    @Override
    public void spawnCrustacean(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 2) {

            GiantCrab giantCrab = new GiantCrab();
            resetManager.registerResettable(giantCrab, giantCrab);

            location.addActor(giantCrab);
        }
    }
}