package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.actionsgame.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemies extends Actor{
    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    int numOfRunes;
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemies(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        FollowBehaviour followBehaviour = new FollowBehaviour(otherActor);
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
            // HINT 1: The AttackAction above allows you to attak the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?
            if(followContained(followBehaviour)){
                behaviours.clear();
                behaviours.put(1, new AttackBehaviour(otherActor));
                behaviours.put(500, followBehaviour);
            }
        }

        return actions;
    }
    public abstract Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display);
    public void getParticularEnemy(){

    };

//    public int dropRunes(Character displayChar){
//        int numOfRunes = 0;
//        if (displayChar == 'c'){ numOfRunes = RandomNumberGenerator.getRandomInt(318, 4961);}
//        else if (displayChar == 'h'){ numOfRunes = RandomNumberGenerator.getRandomInt(55, 1470);}
//        else if (displayChar == 'q') { numOfRunes = RandomNumberGenerator.getRandomInt(35, 892);}
//        return numOfRunes;
//
//    };

    public boolean followContained(FollowBehaviour behaviourContained){
        for(int i : behaviours.keySet()){
            if(behaviours.get(i) == behaviourContained){
                return true;
            }
        }
        return false;
    }


}
