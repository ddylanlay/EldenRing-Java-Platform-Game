package game.environments.west;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.HeavySkeletalSwordsman;
import game.environments.enemyfactory.SkeletonFactory;
import game.utils.RandomNumberGenerator;

/**
 * @author Jamie Tran
 */
public class WestGraveyard extends Ground implements SkeletonFactory {

    public WestGraveyard(){
        super('n');
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100)<=27){
                // create actor heavy skeletal swordsman
                spawnSkeleton(spawnLocation);
            }
        }


    }
    @Override
    public void spawnSkeleton(Location location){
        location.addActor(new HeavySkeletalSwordsman());
    }
}
