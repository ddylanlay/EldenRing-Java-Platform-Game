package game.trading;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Runes;

import java.util.HashMap;

public class RunesManager {
    private HashMap<Actor, Integer> runesList;

    private Runes oldRunes = null;
    private Location droppedRunesLocation = null;
    private boolean haveRunesCollected = true;

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


    public void playerRetrieveDroppedRunes(){
        haveRunesCollected = true;
        droppedRunesLocation = null;
        oldRunes = null;
    }

    public void playerDied(Location dropLocation, Actor target, GameMap map){

        Runes deathRunes = new Runes(retrieveActorsRunes(target)); //New runes to drop
        removeRunes(target, deathRunes.getValue()); //Remove runes from player
        map.at(dropLocation.x(), dropLocation.y()).addItem(deathRunes); //Drop item on the ground

        //If runes haven't been collected, remove them from the gamemap
        if (!haveRunesCollected){
            map.at(droppedRunesLocation.x(), droppedRunesLocation.y()).removeItem(oldRunes);
        }

        //Update our old runes item
        oldRunes = deathRunes;
        //Update the drop location
        droppedRunesLocation = dropLocation;
        //Make sure to set haveRunesCollected to be false
        haveRunesCollected = false;
    }

}


//    public void dropRunes(Actor actor, GameMap map){
//        Enemies enemy = (Enemies) actor;
//        int runes = enemy.dropRunes();
//        for(int i = 0; i <= runes; i++) {
//            map.locationOf(enemy).addItem(item);
//        }
//    }


