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
		this.lastGraceSite = lastGraceSite;
		runesManager.storeActorsRunes(this, 300);
		resetManager.registerResettable(this, this);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		if (hitPoints <= 0) {
			Location location = map.locationOf(this);
			location.setGround(new Runes(this, location.getGround()));

			// return/print the console menu
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



	/*
	Resettable Interface Methods
	 */

	/**
	 * Reset method for the player, restores health and moves to Site of Lost Grace.
	 *
	 * @param gameMap map the player is on, class GameMap.
	 */
	@Override
	public void reset(GameMap gameMap) {

		//Restore health
		hitPoints = maxHitPoints;

		if (!(gameMap.locationOf(this) == lastGraceSite)){
			//Move to correct position in game map
			gameMap.moveActor(this, lastGraceSite);
		}

	}

	/**
	 * Tells us whether this is the player or not.
	 *
	 * @return True, this is the player.
	 */
	@Override
	public boolean isPlayer() { return true; }

	/**
	 * Sets the last site of grace the player has visited.
	 *
	 * @param lastSiteOfGrace Location class, containing last Site of Grace that was interacted with.
	 */
	@Override
	public void setLastSiteOfGrace(Location lastSiteOfGrace) {
		this.lastGraceSite = lastSiteOfGrace;
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


	/**
	 * @return
	 */
	public int getNumOfRunes() {
		return runesManager.retrieveActorsRunes(this);
	}


	public void setPreviousLocation(Location previousLocation) { this.previousLocation = previousLocation; }

}
