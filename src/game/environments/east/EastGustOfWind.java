package game.environments.east;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GiantDog;
import game.environments.enemyfactory.CanisFactory;
import game.utils.RandomNumberGenerator;

/**
 * @author Jamie Tran
 */
public class EastGustOfWind extends Ground implements CanisFactory {

    public EastGustOfWind(){
        super('&');
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100)<=4){
                // create actor lone wolf
            }
        }


    }
    public void spawnCanis(Location location){
        location.addActor(new GiantDog());
    }
}
