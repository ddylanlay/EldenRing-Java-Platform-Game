package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;

public class ResetAction extends Action {

    private String siteName;
    private Location locationOfSite;
    ResetManager resetManager = ResetManager.getInstance();

    public ResetAction(String siteName, Location locationOfSite){
        this.siteName = siteName;
        this.locationOfSite = locationOfSite;
    }

    @Override
    public String execute(Actor actor, GameMap map){
        resetManager.updatePlayerSiteLocation(actor, locationOfSite);
        resetManager.run(map);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {

        return actor.toString() + " rests at the " + siteName + " Site of Lost Grace";
    }
}
