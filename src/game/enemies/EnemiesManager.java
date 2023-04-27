package game.enemies;

import java.util.HashMap;
import java.util.Map;

public class EnemiesManager {
    static Map<Character, Enemies> enemiesList = new HashMap<>();
    static GiantCrab giantCrab;
    static LoneWolf loneWolf;
    public EnemiesManager(){
    }

    // CURRENTLY BEING HARDCODED
//    public static Enemies displayEnemies(Character chars) {
////        enemiesList.put('c', giantCrab);
////        enemiesList.put('h', loneWolf);
////        return enemiesList.get(chars);
//    }


}
