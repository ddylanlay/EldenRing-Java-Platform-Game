package game.trading;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.HashMap;
import java.util.Map;

public class RunesManager{

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
    public void transferRunes(Actor loser, Actor gainer){
    }

    public void addRunes(int runes, Actor actor){

    }


//    public void dropRunes(Actor actor, GameMap map){
//        Enemies enemy = (Enemies) actor;
//        int runes = enemy.dropRunes();
//        for(int i = 0; i <= runes; i++) {
//            map.locationOf(enemy).addItem(item);
//        }
//    }

}
