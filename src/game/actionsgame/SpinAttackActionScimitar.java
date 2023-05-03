package game.actionsgame;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.trading.RunesManager;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;

public class SpinAttackActionScimitar extends WeaponAction{
    private ArrayList<Actor> actorInRange = new ArrayList<>();
    RunesManager runesManager = RunesManager.getInstance();

    public SpinAttackActionScimitar(WeaponItem weapon) {
        super(weapon);
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        scanAround(actor, map);
        String result = "";
        for(Actor target: actorInRange){
            if(RandomNumberGenerator.getRandomInt(100)<=88){
                actor.hurt(118);
                System.out.println(target + " is sliced for 118 damage.");
                if (!actor.isConscious()) {
                    int numOfRunes = runesManager.transferRunes(target, actor);
                    String string = target + " drops " + numOfRunes + " runes";
                    result += System.lineSeparator() + string;
                    return result;
                }
            }
            else{
                System.out.println(actor + " missed the " + target);
            }
        }
        System.out.println(actorInRange);
        actorInRange.clear();
        return result;
    }

    public void scanAround(Actor actor, GameMap map){
        Location actorLocation = map.locationOf(actor);
        int xLocation = actorLocation.x();
        int yLocation = actorLocation.y();

        for(int x = xLocation - 1; x <= xLocation + 1; x++){
            for(int y = yLocation - 1; y <= yLocation + 1; y++){
                Location tempLocation = new Location(map, x, y);
                if(map.isAnActorAt(tempLocation) && map.getActorAt(tempLocation) != actor){
                    actorInRange.add(map.getActorAt(tempLocation));

                }
            }
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks anything in the surrounding with Scimitar";
    }
}

