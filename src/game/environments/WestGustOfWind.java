package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GiantDog;
import game.enemies.LoneWolf;
import game.utils.RandomNumberGenerator;

public class WestGustOfWind extends Ground implements CanisFactory {

    public WestGustOfWind(){
        super('&');
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100)<=33){

                spawnCanis(spawnLocation);
            }
        }


    }
    public void spawnCanis(Location location){
        location.addActor(new LoneWolf());
    }
}

