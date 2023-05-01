package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;

public class ResetAction extends Action {

    private String siteName;
    ResetManager resetManager = ResetManager.getInstance();

    public ResetAction(String siteName){
        this.siteName = siteName;
    }

    @Override
    public String execute(Actor actor, GameMap map){
        resetManager.run(map);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {

        return actor.toString() + " rests at the " + siteName + " Site of Lost Grace";
    }
}
