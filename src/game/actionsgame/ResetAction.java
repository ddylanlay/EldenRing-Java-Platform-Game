package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.FancyMessage;
import game.ResetManager;
import game.environments.GraceDiscoverCapability;

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

        //Print grace discovery message if it has the capability to
        Ground site = locationOfSite.getGround();
        if (site.hasCapability(GraceDiscoverCapability.NOT_DISCOVERED)){
            site.removeCapability(GraceDiscoverCapability.NOT_DISCOVERED); //Remove capability
            System.out.println(FancyMessage.GRACE_DISCOVER);
        }

        resetManager.run(map);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {

        return actor.toString() + " rests at the " + siteName + " Site of Lost Grace";
    }
}
