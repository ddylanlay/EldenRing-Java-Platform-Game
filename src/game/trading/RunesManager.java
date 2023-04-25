package game.trading;

import edu.monash.fit2099.engine.actors.Actor;
import game.Player;
import game.enemies.Enemies;

public class RunesManager{
//    private static RunesManager instance;
//
//    public static RunesManager getInstance(){
//        if(instance == null) {
//            instance = new RunesManager();
//        }
//        return instance;
//    }
    public int transferRunes(Actor loser, Actor gainer) {
        int runes = ((Enemies) loser).dropRunes(loser.getDisplayChar());
        ((Player) gainer).addRunes(runes);
        return runes;
    }

}


//    public void dropRunes(Actor actor, GameMap map){
//        Enemies enemy = (Enemies) actor;
//        int runes = enemy.dropRunes();
//        for(int i = 0; i <= runes; i++) {
//            map.locationOf(enemy).addItem(item);
//        }
//    }


