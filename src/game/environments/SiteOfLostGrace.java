package game.environments;

import edu.monash.fit2099.demo.mars.actions.WindowSmashAction;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actionsgame.ResetAction;

/**
 * Site Of Lost Grace, allows players to heal and resets world.
 *
 * Created by:
 * @author Arosh Heenkenda
 *
 * Modified by:
 *
 */
public class SiteOfLostGrace extends Ground {

    /**
     * Name of the Site of Lost Grace
     */
    private String siteName;

    /**
     * Location of the site
     */
    private Location locationOfSite;

    /**
     * Constructor.
     *
     */
    public SiteOfLostGrace(String siteName, Location locationOfSite) {

        super('U');
        this.siteName = siteName;
        this.locationOfSite = locationOfSite;
        addCapability(GraceDiscoverCapability.DISCOVER_FALSE);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String directionA){
        return new ActionList(new ResetAction(siteName, locationOfSite));
    }
}
