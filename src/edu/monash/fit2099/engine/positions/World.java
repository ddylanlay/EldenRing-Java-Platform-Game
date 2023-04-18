package edu.monash.fit2099.engine.positions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class representing the game world, including the locations of all Actors, the
 * player, and the playing grid.
 */
public class World {
	protected Display display;
	protected ArrayList<GameMap> gameMaps = new ArrayList<GameMap>();
	protected ActorLocationsIterator actorLocations = new ActorLocationsIterator();
	protected Actor player; // We only draw the particular map this actor is on.
	protected Map<Actor, Action> lastActionMap = new HashMap<Actor, Action>();

	/**
	 * Constructor.
	 * 
	 * @param display the Display that will display this World.
	 */
	public World(Display display) {
		Objects.requireNonNull(display);
		this.display = display;
	}

	/**
	 * Add a GameMap to the World.
	 * @param gameMap the GameMap to add
	 */
	public void addGameMap(GameMap gameMap) {
		Objects.requireNonNull(gameMap);
		gameMaps.add(gameMap);
		gameMap.actorLocations = actorLocations;
	}

	/**
	 * Set an actor as the player. The map is drawn just before this Actor's turn
	 * 
	 * @param player   the player to add
	 * @param location the Location where the player is to be added
	 */
	public void addPlayer(Actor player, Location location) {
		this.player = player;
		actorLocations.add(player, location.map().at(location.x(), location.y()));
		actorLocations.setPlayer(player);
	}

	/**
	 * Run the game.
	 *
	 * On each iteration the gameloop does the following: - displays the player's
	 * map - processes the actions of every Actor in the game, regardless of map
	 *
	 * We could either only process the actors on the current map, which would make
	 * time stop on the other maps, or we could process all the actors. We chose to
	 * process all the actors.
	 *
	 * @throws IllegalStateException if the player doesn't exist
	 */
	public void run() {
		if (player == null)
			throw new IllegalStateException();

		// initialize the last action map to nothing actions;
		for (Actor actor : actorLocations) {
			lastActionMap.put(actor, new DoNothingAction());
		}

		// This loop is basically the whole game

		// game runs as long as player is still alive and  can be found in one of the game maps within the game world
		while (stillRunning()) {
			// gets map where player is currently located
			// .locationof gets the location of the player then .map gets the specific game map where that location is found
			GameMap playersMap = actorLocations.locationOf(player).map();

			// draws each (x,y) position in the game map
			playersMap.draw(display);

			// Process each actor's turn
			for (Actor actor : actorLocations) {
				// checks if player is alive in case heavy blow from enemy removes player from game map during the same turn as checking
				if (stillRunning())
					processActorTurn(actor);
			}

			// Tick over all the maps. For the map stuff.
			for (GameMap gameMap : gameMaps) {
				gameMap.tick();
			}

		}
		display.println(endGameMessage());
	}

	/**
	 * Gives an Actor its turn.
	 *
	 * The Actions an Actor can take include:
	 * <ul>
	 * <li>those conferred by items it is carrying</li>
	 * <li>movement actions for the current location and terrain</li>
	 * <li>actions that can be done to Actors in adjacent squares</li>
	 * <li>actions that can be done using items in the current location</li>
	 * <li>skipping a turn</li>
	 * </ul>
	 *
	 * @param actor the Actor whose turn it is.
	 */
	protected void processActorTurn(Actor actor) {
		Location here = actorLocations.locationOf(actor); // gets specific location
		GameMap map = here.map(); // gets specific game map based on specific location


		ActionList actions = new ActionList();
		// loops through all items carried by actor and checks what actions are possible by the player with the particular item
		for (Item item : actor.getItemInventory()) {
			actions.add(item.getAllowableActions());
			// Game rule. If you're carrying it, you can drop it.
			actions.add(item.getDropAction(actor));
		}

		// for weapons with non-offensive special skill, e.g. increase actor's HP, etc.
		for (WeaponItem weapon : actor.getWeaponInventory()) {
			actions.add(weapon.getAllowableActions());
			actions.add(weapon.getDropAction(actor));
		}

		// Game rule. Allows the actor to interact with current ground
		actions.add(here.getGround().allowableActions(actor, here, ""));

		// other actors and ground reachable from current actor's exits, 8 surrounding squares
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();

			if (actorLocations.isAnActorAt(destination)) {
				// actions with other actors in that direction
				actions.add(actorLocations.getActorAt(destination).allowableActions(actor, exit.getName(), map));
			} else {
				// otherwise actions they can do to the ground in that direction
				actions.add(destination.getGround().allowableActions(actor, destination, exit.getName()));
			}
			// gives a MoveActorAction to a particular direction if the actor can go there
			actions.add(destination.getMoveAction(actor, exit.getName(), exit.getHotKey()));
		}

		// if actor is currently standing on item that is on the ground, they can do something with it
		for (Item item : here.getItems()) {
			actions.add(item.getAllowableActions());
			// Game rule. If it's on the ground you can pick it up.
			actions.add(item.getPickUpAction(actor));
		}
		// if they choose to do nothing in that turn
		actions.add(new DoNothingAction());
		// collected list of actions that can be performed by actor during that turn
		Action action = actor.playTurn(actions, lastActionMap.get(actor), map, display);

		// records the list of actions in lastActionMap
		lastActionMap.put(actor, action);

		// execute action that is chosen in the current turn and display result of the action
		String result = action.execute(actor, map);
		display.println(result);
	}

	/**
	 * Returns true if the game is still running.
	 *
	 * The game is considered to still be running if the player is still around.
	 *
	 * @return true if the player is still on the map.
	 */
	protected boolean stillRunning() {
		return actorLocations.contains(player);
	}

	/**
	 * Return a string that can be displayed when the game ends.
	 *
	 * @return the string "Game Over"
	 */
	protected String endGameMessage() {
		return "Game Over";
	}
}
