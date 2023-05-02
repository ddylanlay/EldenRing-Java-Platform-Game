package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.combatclass.CombatClass;
import game.items.FlaskOfCrimsonTears;
import game.trading.Runes;
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
	private Location previousLocation;

	private final Menu menu = new Menu();
	private CombatClass combatClass;
	RunesManager runesManager = RunesManager.getInstance();

	private Location lastGraceSite;

	//every time a new player is made, a new instance of flask of crimson tears comes with it
	public FlaskOfCrimsonTears bottle = FlaskOfCrimsonTears.getInstance();
	public ResetManager resetManager = ResetManager.getInstance();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints, Location lastGraceSite) {
		// name and displayChar are altered in the Application class
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addItemToInventory(bottle);
		setLastGraceSite(lastGraceSite);
		runesManager.storeActorsRunes(this, 9999);
		resetManager.registerResettable(this, this);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		playerDescription();
		if (hitPoints <= 0) {
			Location location = map.locationOf(this);
			location.setGround(new Runes(this, location.getGround()));

			// return/print the console menu
		}
			return menu.showMenu(this, actions, display);
		}

		playerDescription();
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
		ActionList actions = new ActionList();
		return actions;
	}

	/**
	 * Reset method for the player, restores health and moves to Site of Lost Grace.
	 *
	 * @param gameMap map the player is on, class GameMap.
	 */
	@Override
	public void reset(GameMap gameMap) {

		//Restore health
		hitPoints = maxHitPoints;

		//Move to correct position in game map
		gameMap.moveActor(this, lastGraceSite);
	}

	@Override
	public boolean isPlayer() { return true; }


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


	/**
	 * @return
	 */
	public int getNumOfRunes() {
		return runesManager.retrieveActorsRunes(this);
	}


	/**
	 * Setter for lastGraceSite attribute.
	 *
	 * @param lastGraceSite the last Site of Lost Grace visited, as a Location.
	 */
	public void setLastGraceSite(Location lastGraceSite) { this.lastGraceSite = lastGraceSite; }

	public void setPreviousLocation(Location previousLocation) { this.previousLocation = previousLocation; }

}
