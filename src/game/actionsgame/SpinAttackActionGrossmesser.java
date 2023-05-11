package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.trading.RunesManager;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;

public class SpinAttackActionGrossmesser extends Action {
    private ArrayList<Actor> actorInRange = new ArrayList<>();
    RunesManager runesManager = RunesManager.getInstance();
    private Weapon weapon;
    public SpinAttackActionGrossmesser(Weapon weapon) {
        this.weapon = weapon;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        scanAround(actor, map);
        String result = "";
        for (Actor target : actorInRange) {
            if (RandomNumberGenerator.getRandomInt(100) <= 100) {
                target.hurt(weapon.damage());
                result += target + " is sliced for 115 damage." + System.lineSeparator();
                if (!actor.isConscious()) {
                    result += new DeathAction(actor).execute(target, map);
                    if (actor.getDisplayChar() == '@' && target.getDisplayChar() != '@') {
                        int numOfRunes = runesManager.transferRunes(target, actor);
                        String string = target + " drops " + numOfRunes + " runes";
                        result += System.lineSeparator() + string;
                    }
                }
            }
            else{result += actor + " missed the " + target + System.lineSeparator();}

        }
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
                if(map.isAnActorAt(tempLocation) && map.getActorAt(tempLocation) != actor && map.getActorAt(tempLocation).getDisplayChar() != 'K'){
                    actorInRange.add(map.getActorAt(tempLocation));
                }
            }
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks anything in the surrounding with" + weapon;
    }
}
