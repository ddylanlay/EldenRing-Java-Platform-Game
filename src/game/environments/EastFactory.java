package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GiantCrayfish;
import game.enemies.GiantDog;
import game.enemies.SkeletalBandit;
import game.utils.RandomNumberGenerator;

public class EastFactory implements EnemiesFactory {
    @Override
    public void spawnCanis(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 4) {
            location.addActor(new GiantDog());
        }
    }

    @Override
    public void spawnSkeleton(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 27) {
            location.addActor(new SkeletalBandit());
        }
    }

    @Override
    public void spawnCrustacean(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 1) {
            location.addActor(new GiantCrayfish());

        }
    }
}
