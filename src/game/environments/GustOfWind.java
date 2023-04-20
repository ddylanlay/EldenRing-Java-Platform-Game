package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

public class GustOfWind extends Ground {

    public GustOfWind(){
        super('&');
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100)<=33){
                // create actor lone wolf
            }
        }


    }
}
