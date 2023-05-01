package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Player;
import game.enemies.Enemies;
import game.trading.RunesManager;

import java.util.Random;

/**
 * An Action to attack another Actor.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	private Actor target;
	private Enemies enemyTarget;
	/**
	 * The direction of incoming attack.
	 */
	private String direction;

	/**
	 * Random number generator
	 */
	private Random rand = new Random();

	/**
	 * Weapon used for the attack
	 */
	private Weapon weapon;
	RunesManager runesManager = RunesManager.getInstance();

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 * @param direction the direction where the attack should be performed (only used for display purposes)
	 */
	public AttackAction(Actor target, String direction, Weapon weapon) {
		this.target = target;
		this.direction = direction;
		this.weapon = weapon;
	}

	/**
	 * Constructor with intrinsic weapon as default
	 *
	 * @param target the actor to attack
	 * @param direction the direction where the attack should be performed (only used for display purposes)
	 */
	public AttackAction(Actor target, String direction) {
		this.target = target;
		this.direction = direction;
	}

	/**
	 * When executed, the chance to hit of the weapon that the Actor used is computed to determine whether
	 * the actor will hit the target. If so, deal damage to the target and determine whether the target is killed.
	 *
	 * @param actor The actor performing the attack action.
	 * @param map The map the actor is on.
	 * @return the result of the attack, e.g. whether the target is killed, etc.
	 * @see DeathAction
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		System.out.println(weapon);
		Weapon weapon = equipWeapon(actor);
		if (weapon == null) {
			weapon = actor.getIntrinsicWeapon();
		}


		if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
			return actor + " misses " + target + ".";
		}

		int damage = weapon.damage();
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
		target.hurt(damage);
		if (!target.isConscious()) {
			result += new DeathAction(actor).execute(target, map);
			if (actor.getDisplayChar() == '@' && target.getDisplayChar() != '@'){
				int numOfRunes = runesManager.transferRunes(target, actor);
				String string = target + " drops " + numOfRunes + " runes";
				result += System.lineSeparator() + string;
				System.out.println(((Player) actor).getNumOfRunes());
				return result;
				}

			}

		return result;
	}

	/**
	 * Describes which target the actor is attacking with which weapon
	 *
	 * @param actor The actor performing the action.
	 * @return a description used for the menu UI
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
	}

	public Weapon equipWeapon(Actor actor){
		for(Weapon weapon : actor.getWeaponInventory()){
			System.out.println(asWeapon(weapon));
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
