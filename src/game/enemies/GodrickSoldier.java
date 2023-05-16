package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Resettable;
import game.Status;
import game.actionsgame.AttackAction;
import game.actionsgame.AttackActionIntrinsic;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.utils.RandomNumberGenerator;

public class GodrickSoldier extends Enemies implements Resettable {
    public GodrickSoldier() {
        super("Godrick Solider", 'p', 198);
        behaviours.put(999, new WanderBehaviour());
        runesManager.storeActorsRunes(this,dropRunes());
        resetManager.registerResettable(this, this);
        this.hasCapability(EnemyType.STORMVEIL);
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
    public void reset(GameMap gameMap) { gameMap.removeActor(this);

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
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        FollowBehaviour followBehaviour = new FollowBehaviour(otherActor);
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && !(otherActor.hasCapability(EnemyType.STORMVEIL))){
            actions.add(new AttackAction(this, direction, equipWeapon(otherActor)));
            actions.add(new AttackActionIntrinsic(this, direction));
            // HINT 1: The AttackAction above allows you to attak the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?
            if(followContained(followBehaviour) == false){
                behaviours.clear();
                behaviours.put(1, new AttackBehaviour(otherActor));
                behaviours.put(500, followBehaviour);
            }
        }

        return actions;
    }
}
