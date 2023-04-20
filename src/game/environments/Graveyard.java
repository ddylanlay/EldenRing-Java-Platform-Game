package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

public class Graveyard extends Ground {

    public Graveyard(){
        super('n');
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100)<=27){
                // create actor heavy skeletal swordsman
            }
        }


    }
}
