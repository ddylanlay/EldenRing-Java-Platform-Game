package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.combatclass.CombatClass;
import game.trading.Runes;
import game.weapons.Club;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 *
 * Created by:
 * @author Adrian Kristanto
 *
 * Modified by:
 * @author Arosh Heenkenda
 */
public class Player extends Actor implements Resettable, Runes {

	private final Menu menu = new Menu();
	int runesInInventory = 0;

	private CombatClass combatClass;


	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super("Tarnished", '@', hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addWeaponToInventory(new Club());
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}


	@Override
	public void reset() {}



	/**
	 * Getter for combatClass.
	 *
	 * @return a CombatClass object.
	 */
	public CombatClass getCombatClass() { return combatClass; }

	/**
	 * Setter for combatClass.
	 *
	 * @param combatClass a CombatClass object.
	 */
	public void setCombatClass(CombatClass combatClass) { this.combatClass = combatClass; }
	public int addRunes(int runes){
		runesInInventory = runesInInventory + runes;
		return runesInInventory;
	}

	// may need to make a boolean method to check for invalid purchase

	public int removeRunes(int runes){
		if (runesInInventory - runes >= 0){
			runesInInventory = runesInInventory - runes;
		}
		return runesInInventory;
	}

}
