package game.environments.west;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GiantCrab;
import game.environments.enemyfactory.CrustaceanFactory;
import game.utils.RandomNumberGenerator;

public class WestPuddleOfWater extends Ground implements CrustaceanFactory {

    public WestPuddleOfWater(){
        super('~');
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100)<=2){
                // create actor giant crab or giant crayfish
            }
        }


    }
    public void spawnCrustacean(Location location){
        location.addActor(new GiantCrab());
    }
}
