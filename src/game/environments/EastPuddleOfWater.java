package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GiantCrab;
import game.enemies.GiantCrayfish;
import game.utils.RandomNumberGenerator;

public class EastPuddleOfWater extends Ground implements CrustaceanFactory{

    public EastPuddleOfWater(){
        super('~');
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100)<=2){
                // create actor giant crab or giant crayfish
                spawnCrustacean(spawnLocation);
            }
        }


    }

    public void spawnCrustacean(Location location){
        location.addActor(new GiantCrayfish());
    }
}
