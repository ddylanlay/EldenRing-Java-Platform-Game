package game.environments;

import edu.monash.fit2099.engine.positions.Location;

public interface EnemiesFactory {
    public void spawnCrustacean(Location location);
    public void spawnSkeleton(Location location);
    public void spawnCanis(Location location);


}
