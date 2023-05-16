package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Ally;
import game.enemies.Invader;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;

public class SpawnAction extends Action {
    private ArrayList<Location> locationInRange = new ArrayList<>();
    private Location location;;
    public SpawnAction(Location location){
        this.location = location;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        int xLocation = location.x();
        int yLocation = location.y();
        Ground ground = location.getGround();
        for(int x = xLocation - 1; x <= xLocation + 1; x++){
            for(int y = yLocation - 1; y <= yLocation + 1; y++){
                Location tempLocation = map.at(x,y);
                if(!map.isAnActorAt(tempLocation)){
                    locationInRange.add(tempLocation);

                }
            }
        }
        if(locationInRange.isEmpty() == false){
            Location spawnLocation = locationInRange.get(0);
            if (RandomNumberGenerator.getRandomInt(100) <= 50) {
                spawnLocation.addActor(new Invader(RandomNumberGenerator.getRandomCombatClass()));
                result += "Invader spawned";
            }
            else{
                spawnLocation.addActor(new Ally(RandomNumberGenerator.getRandomCombatClass()));
                result += "Ally spawned";
            }
            System.out.println((spawnLocation.x()));
            System.out.println((spawnLocation.y()));
            System.out.println((spawnLocation.getGround()));
        } else{
            result += "Unable to spawn Ally or Invader";
            return result;
        }



        locationInRange.clear();
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " spawns an Ally or Invader";
    }
}

