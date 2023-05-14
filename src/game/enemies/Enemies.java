package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.ResetManager;
import game.Status;
import game.actionsgame.AttackAction;
import game.actionsgame.QuickstepAttackAction;
import game.actionsgame.UnsheatheAttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.trading.RunesManager;
import game.weapons.WeaponType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Enemies extends Actor{
    public Map<Integer, Behaviour> behaviours = new HashMap<>();
    RunesManager runesManager = RunesManager.getInstance();
    ResetManager resetManager = ResetManager.getInstance();
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
        if(this.hasCapability(Status.BURNED)) {
            this.hurt(5);
            System.out.println(this + " has been burnt for 5 damage");
        }

    }


    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        List<WeaponItem> weaponInventory = otherActor.getWeaponInventory();
        FollowBehaviour followBehaviour = new FollowBehaviour(otherActor);
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
            actions.add(new AttackAction(this, direction, equipWeapon(otherActor)));
            for (WeaponItem weapon : weaponInventory) {
                if (weapon.hasCapability(WeaponType.KATANA)) {
                    actions.add(new UnsheatheAttackAction(this, direction, weapon));
                } else if (weapon.hasCapability(WeaponType.DAGGER)) {
                    actions.add(new QuickstepAttackAction(this, direction, weapon));
                }
            }

            // HINT 1: The AttackAction above allows you to attak the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?
            if(!followContained(followBehaviour)){
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

    public boolean followContained(FollowBehaviour behaviourContained){
        for(int i : behaviours.keySet()){
            if(behaviours.get(i) == behaviourContained){
                return true;
            }
        }
        return false;
    }

    public boolean wanderContained(){
        for(int i : behaviours.keySet()){
            if(behaviours.get(i) instanceof WanderBehaviour){
                return true;
            }
        }
        return false;
    }
    public Weapon equipWeapon(Actor actor){
        for(Weapon weapon : actor.getWeaponInventory()){

            if(asWeapon(weapon) != null){

                return weapon;
            }
        }
        return actor.getIntrinsicWeapon();
    }
    public Weapon asWeapon(Weapon weapon){
        return weapon instanceof Weapon ? weapon : null;
    }


}
