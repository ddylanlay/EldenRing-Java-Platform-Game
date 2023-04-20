package game;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.ArrayList;
import java.util.List;

public class RunesManager{

    private List<Runes> runesList;
    private static RunesManager instance;

    public RunesManager(){
        this.runesList = new ArrayList<>();
    }

    public static RunesManager getInstance(){
        if(instance == null) {
            instance = new RunesManager();
        }
        return instance;
    }
    @Override
    public void exchangeRunes(Runes runes){
//        runes.addRunes(runesInInventory);
//        runes.
    }

    public boolean addRunes(Actor actor, int runes){
    }

}
