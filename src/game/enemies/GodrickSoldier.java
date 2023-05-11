package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Resettable;
import game.Status;
import game.behaviours.WanderBehaviour;
import game.utils.RandomNumberGenerator;

public class GodrickSoldier extends Enemies implements Resettable {
    public GodrickSoldier() {
        super("Godrick Solider", 'p', 198);
        behaviours.put(999, new WanderBehaviour());
        runesManager.storeActorsRunes(this,dropRunes());
        resetManager.registerResettable(this, this);
    }
    public int dropRunes()
    {
        return RandomNumberGenerator.getRandomInt(38, 70);
    }
    @Override
    public void reset(GameMap gameMap) {

    }

    @Override
    public boolean isPlayer() {
        boolean value = false;
        if (this.hasCapability(Status.FAST_TRAVEL)) {
            value = true;
        }
        return value;
    }

    @Override
    public void setLastSiteOfGrace(Location lastSiteOfGrace) {

    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }
}
