package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enemies.Ally;
import game.enemies.Invader;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;

public class SpawnAction extends Action {
    private ArrayList<Location> locationInRange = new ArrayList<>();
    private Location location;
    public SpawnAction(Location location){
        this.location = location;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        int xLocation = location.x();
        int yLocation = location.y();
        for(int x = xLocation - 1; x <= xLocation + 1; x++){
            for(int y = yLocation - 1; y <= yLocation + 1; y++){
                Location tempLocation = new Location(map, x, y);
                if(!map.isAnActorAt(tempLocation) && map.getActorAt(tempLocation) != actor && map.getActorAt(tempLocation).getDisplayChar() != 'K'){
                    locationInRange.add(tempLocation);
                }
            }
        }
        if(locationInRange.isEmpty() == false){
            Location spawnLocation = locationInRange.get(0);
        } else{
            result += "Unable to spawn Ally or Invader";
            return result;
        }

        if (RandomNumberGenerator.getRandomInt(100) <= 50) {
            location.addActor(new Invader(RandomNumberGenerator.getRandomCombatClass()));
            result += "Invader spawned";
        }
        else{
            location.addActor(new Ally(RandomNumberGenerator.getRandomCombatClass()));
            result += "Ally spawned";
        }


        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " spawns an Ally or Invader";
    }
}

