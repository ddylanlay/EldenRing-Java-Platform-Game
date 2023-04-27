package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.SkeletalBandit;
import game.environments.enemyfactory.SkeletonFactory;
import game.utils.RandomNumberGenerator;

/**
 * @author Jamie Tran
 */
public class GustOfWind extends Ground {
    private EnemiesFactory enemiesFactory;
    public GustOfWind(EnemiesFactory enemiesFactory){
        super('&');
        this.enemiesFactory = enemiesFactory;
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            this.enemiesFactory.spawnCanis(spawnLocation);
        }
    }


}

