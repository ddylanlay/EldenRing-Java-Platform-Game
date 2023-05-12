package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Resettable;
import game.Status;
import game.behaviours.Behaviour;
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
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(64, "shoots heavy crossbow", 57);


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
        if(behaviours.get(999) instanceof WanderBehaviour){
            if(RandomNumberGenerator.getRandomInt(100)<= 10){
                resetManager.removeResettable(this); //Remove instance of GiantDog when they despawn
                map.removeActor(this);
                System.out.println(this + " removed from map");
                return new DoNothingAction();
            }
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }
}
