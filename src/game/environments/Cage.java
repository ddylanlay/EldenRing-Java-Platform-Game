package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Dog;
import game.utils.RandomNumberGenerator;

public class Cage extends Ground {
    public Cage(){
        super('<');
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100) <= 37){
                spawnLocation.addActor(new Dog());
            }
        }
    }
}

