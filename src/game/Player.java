package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import game.combatclass.CombatClass;
import game.items.FlaskOfCrimsonTears;
import game.trading.RunesManager;

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
public class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();
	//	int runesInInventory = 99999;
	private CombatClass combatClass;
	RunesManager runesManager = RunesManager.getInstance();

	//every time a new player is made, a new instance of flask of crimson tears comes with it
	public FlaskOfCrimsonTears bottle = FlaskOfCrimsonTears.getInstance();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		// name and displayChar are altered in the Application class
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addItemToInventory(bottle);
		runesManager.storeActorsRunes(this, 9999);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();


		playerDescription();
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
		ActionList actions = new ActionList();
		return actions;
	}
	@Override
	public void reset(GameMap gameMap) {
	}


	/**
	 * Getter for combatClass.
	 *
	 * @return a CombatClass object.
	 */
	public CombatClass getCombatClass() {
		return combatClass;
	}

	/**
	 * Setter for combatClass.
	 *
	 * @param combatClass a CombatClass object.
	 */
	public void setCombatClass(CombatClass combatClass) {
		this.combatClass = combatClass;
	}

	public void playerDescription() {
		System.out.println(name + " (" + hitPoints + "/" + maxHitPoints + "), runes: " + getNumOfRunes());
	}

//	public void addRunes(int runes) {
//		int storedRunes = runesManager.retrieveActorsRunes(this);
//		storedRunes += runes;
//		runesManager.storeActorsRunes(this, storedRunes);
////		runesInInventory = runesInInventory + runes;
//	}
//
//
//	public void removeRunes(int runes) {
//		int storedRunes = runesManager.retrieveActorsRunes(this);
//		storedRunes -= runes;
//		runesManager.storeActorsRunes(this, storedRunes);
////		runesInInventory = runesInInventory - runes;
//	}

	/**
	 * @return
	 */
	public int getNumOfRunes() {
		return runesManager.retrieveActorsRunes(this);
//		return runesInInventory;
	}

//	public void inputRunes(RunesManager runesManager){
//		runesManager.storeActorsRunes(this, 0);
//	}

}
