package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.actionsgame.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.trading.RunesManager;
import game.utils.RandomNumberGenerator;
import game.weapons.Grossmesser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jamie Tran
 */
public class HeavySkeletalSwordsman extends Enemies {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    RunesManager runesManager = RunesManager.getInstance();

    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.behaviours.put(999, new WanderBehaviour());
        addWeaponToInventory(new Grossmesser());
        runesManager.storeActorsRunes(this,dropRunes());
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(behaviours.get(999) instanceof WanderBehaviour == true){
            if(RandomNumberGenerator.getRandomInt(100)<= 10){
                map.removeActor(this);
            }
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The lone wolf can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        FollowBehaviour followBehaviour = new FollowBehaviour(otherActor);
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
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


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
    public int dropRunes(){
        return RandomNumberGenerator.getRandomInt(35, 892);
    }



    public WeaponItem getWeaponItem() {
        return new Grossmesser();
    }



    public void spawnPileOfBones(GameMap map) {
        Location currentLocation = map.locationOf(this);
        if(isConscious() == false){
            map.removeActor(this);
            map.addActor(new PilesOfBonesHSS(), currentLocation);
        }
    }
    public boolean followContained(FollowBehaviour behaviourContained){
        for(int i : behaviours.keySet()){
            if(behaviours.get(i) == behaviourContained){
                return true;
            }
        }
        return false;
    }
}