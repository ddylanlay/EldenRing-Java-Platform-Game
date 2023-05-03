package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enemies.Enemies;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;

public class SlamAttackAction extends Action {
    private ArrayList<Actor> actorInRange = new ArrayList<>();
    private Actor actor;

    public SlamAttackAction(Actor actor){
        this.actor = actor;

    }

    public String execute(Actor actor, GameMap map) {
        Weapon weapon = actor.getIntrinsicWeapon();
        scanAround(actor, map);
        String result = "";
        for(Actor target: actorInRange){
            if(RandomNumberGenerator.getRandomInt(100)<=weapon.chanceToHit()){
                actor.hurt(weapon.damage());
                System.out.println(target + " is slammed for " + weapon.damage() + " damage.");
                if(actor.isConscious() == false){
                    map.removeActor(target);
                    System.out.println(target + " has been killed.");
                }
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
        return "Slam Attack";
    }
}

