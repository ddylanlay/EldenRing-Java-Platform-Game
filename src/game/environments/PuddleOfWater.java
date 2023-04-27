package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;


/**
 * @author Jamie Tran
 */
public class PuddleOfWater extends Ground {
    private EnemiesFactory enemiesFactory;
    public PuddleOfWater(EnemiesFactory enemiesFactory){
        super('~');
        this.enemiesFactory = enemiesFactory;
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            this.enemiesFactory.spawnCrustacean(spawnLocation);
        }
    }


}

