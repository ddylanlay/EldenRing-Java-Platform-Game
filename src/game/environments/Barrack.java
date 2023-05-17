package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GodrickSoldier;
import game.utils.RandomNumberGenerator;

public class Barrack extends Ground {

    /**
     * Constructor for Barrack
     *
     *
     */
    public Barrack(){
        super('B');
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100) <= 45){
                spawnLocation.addActor(new GodrickSoldier());
            }
        }
    }
}