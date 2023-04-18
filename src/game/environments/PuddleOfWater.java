package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

public class PuddleOfWater extends Ground {

    public PuddleOfWater(){
        super('~');
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100)<=2){
                // create actor giant crab or giant crayfish
            }
        }


    }
}
