package game.environments.east;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GiantCrayfish;
import game.environments.enemyfactory.CrustaceanFactory;
import game.utils.RandomNumberGenerator;

/**
 * @author Jamie Tran
 */
public class EastPuddleOfWater extends Ground implements CrustaceanFactory {

    public EastPuddleOfWater(){
        super('~');
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100)<=1){
                // create actor giant crab or giant crayfish
                spawnCrustacean(spawnLocation);
            }
        }


    }

    public void spawnCrustacean(Location location){
        location.addActor(new GiantCrayfish());
    }
}
