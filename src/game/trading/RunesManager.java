package game.trading;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.ArrayList;
import java.util.List;

public class RunesManager{

    private List<RunesDoing> runesList;
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
    public void transferRunes(Actor loser, Actor gainer){




    }

    public void addRunesToList(RunesDoing runes){
        runesList.add(runes);
    }

}
