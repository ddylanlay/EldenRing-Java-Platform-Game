package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.SkeletalBandit;
import game.environments.enemyfactory.SkeletonFactory;
import game.utils.RandomNumberGenerator;

/**
 * @author Jamie Tran
 */
public class Graveyard extends Ground {
    private EnemiesFactory enemiesFactory;
    public Graveyard(EnemiesFactory enemiesFactory){
        super('n');
        this.enemiesFactory = enemiesFactory;
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100)<=27){
                this.enemiesFactory.spawnSkeleton(spawnLocation);
            }
        }


    }
}
