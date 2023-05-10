package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class SummonSign extends Ground {
    private EnemiesFactory enemiesFactory;
    public SummonSign(EnemiesFactory enemiesFactory){
        super('=');
        this.enemiesFactory = enemiesFactory;
    }
    public void tick(Location spawnLocation){
        if(!spawnLocation.containsAnActor()){
            this.enemiesFactory.spawnSkeleton(spawnLocation);
        }
    }


}