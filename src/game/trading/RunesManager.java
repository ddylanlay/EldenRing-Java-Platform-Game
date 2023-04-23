package game.trading;

import edu.monash.fit2099.engine.actors.Actor;
import game.Player;
import game.enemies.Enemies;

import java.util.HashMap;
import java.util.Map;

public class RunesManager{
    Actor actor;
    static Enemies enemy;
    private Map<Integer, Actor> runesList;
    private static RunesManager instance;

    public RunesManager(){
        this.runesList = new HashMap<>();
    }

    public static RunesManager getInstance(){
        if(instance == null) {
            instance = new RunesManager();
        }
        return instance;
    }
    public static int transferRunes(Enemies dead, Player player){
        // CASTING USED!
        int numOfRunes = dead.dropRunes(dead.getDisplayChar());
        player.addRunes(numOfRunes);
        return numOfRunes;

    }




//    public void dropRunes(Actor actor, GameMap map){
//        Enemies enemy = (Enemies) actor;
//        int runes = enemy.dropRunes();
//        for(int i = 0; i <= runes; i++) {
//            map.locationOf(enemy).addItem(item);
//        }
//    }

}
