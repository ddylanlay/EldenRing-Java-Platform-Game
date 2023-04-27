package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GiantCrayfish;
import game.enemies.GiantDog;
import game.enemies.SkeletalBandit;

public class WestFactory implements EnemiesFactory{
    @Override
    public void spawnCanis(Location location){
        location.addActor(new GiantDog());
    }
    @Override
    public void spawnSkeleton(Location location){
        location.addActor(new SkeletalBandit());
    }
    @Override
    public void spawnCrustacean(Location location){
        location.addActor(new GiantCrayfish());
    }
}
