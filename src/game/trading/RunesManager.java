package game.trading;

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
    public void transferRunes(Actor loser, Actor gainer){
        loser.allowableActions(gainer, )

    }

    public addRunesToList(Runes runes){
        runesList.add(runes);
    }

}
