package game.trading;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.HashMap;

public class RunesManager {
    private HashMap<Actor, Integer> runesList;
    private static RunesManager instance;
    private RunesManager() {
        this.runesList= new HashMap<Actor, Integer>();
    }

    public static RunesManager getInstance() {
        if (instance == null) {
            instance = new RunesManager();
        }
        return instance;
    }
    public void storeActorsRunes(Actor actor, int runes) {
        runesList.put(actor, runes);
    }

    public int retrieveActorsRunes(Actor actor) {
        return runesList.get(actor);
    }
    public int transferRunes (Actor loser, Actor gainer){
        int enemyRunes = retrieveActorsRunes(loser);
        int playerRunes = retrieveActorsRunes(gainer);
        playerRunes += enemyRunes;
        storeActorsRunes(gainer, playerRunes);
        return enemyRunes;
    }
    public void addRunes(Actor actor, int runes){
        int newTotalRunes = retrieveActorsRunes(actor);
        newTotalRunes += runes;
        storeActorsRunes(actor, newTotalRunes);

    }
    public void removeRunes(Actor actor, int runes){
        int newTotalRunes = retrieveActorsRunes(actor);
        newTotalRunes -= runes;
        storeActorsRunes(actor, newTotalRunes);

    }

}


//    public void dropRunes(Actor actor, GameMap map){
//        Enemies enemy = (Enemies) actor;
//        int runes = enemy.dropRunes();
//        for(int i = 0; i <= runes; i++) {
//            map.locationOf(enemy).addItem(item);
//        }
//    }


