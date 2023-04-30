package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.enemies.GiantCrayfish;
import game.enemies.GiantDog;
import game.enemies.SkeletalBandit;
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
public class EastFactory implements EnemiesFactory {
    private ResetManager resetManager = ResetManager.getInstance();

    @Override
    public void spawnCanis(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 33) {

            GiantDog giantDog = new GiantDog();
            resetManager.registerResettable(giantDog, giantDog);

            location.addActor(giantDog);
        }
    }

    @Override
    public void spawnSkeleton(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 27) {

            SkeletalBandit skeletalBandit = new SkeletalBandit();
            resetManager.registerResettable(skeletalBandit, skeletalBandit);

            location.addActor(skeletalBandit);
        }
    }

    @Override
    public void spawnCrustacean(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 2) {

            GiantCrayfish giantCrayfish = new GiantCrayfish();
            resetManager.registerResettable(giantCrayfish, giantCrayfish);

            location.addActor(giantCrayfish);
        }
    }
}
