package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.combatclass.CombatClassMenu;
import game.enemies.GiantCrab;
import game.enemies.GiantCrayfish;
import game.enemies.LoneWolf;
import game.environments.*;
import game.trading.MerchantKale;
import game.utils.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {
	private static EastFactory eastFactory = new EastFactory();
	private static WestFactory westFactory = new WestFactory();
	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor());
//set ground
		List<String> map = Arrays.asList(
				"...........................................................................",
				"......................#####....######......................................",
				"......................#..___....____#......................................",
				"..................................__#......................................",
				"......................._____........#......................................",
				"......................#............_#......................................",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
				"..................................###___###................................",
				"..................................________#................................",
				"..................................#________................................",
				"..................................#_______#................................",
				"..................................###___###................................",
				"....................................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##....................................................######..##...",
				"..#.....__....................................................#....____....",
				"..#___..........................................................__.....#...",
				"..####__###..................................................._.....__.#...",
				"..............................................................###..__###...",
				"...........................................................................");

//		List<String> map = Arrays.asList(
//				"..nnnn................................................~~~~~~~~~~~~~~~~~~~~~",
//				"......................#####....######..................~~~~~~~~~~~~~~~~~~~~",
//				"..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~",
//				"..................................__#....................~~~~~~~~~~~~~~~~~~",
//				"......................._____........#.....................~~~~~~~~~~~~~~~~~",
//				"......................#............_#......................~~~~~~~~~~~~~~~~",
//				"......................#...........###......................................",
//				"...........................................................................",
//				"...........................................................................",
//				"~~~~~~~~~~~.......................###___###................................",
//				"~~~~~~~~~~~~......................__@_____#....nnnn........................",
//				"~~~~~~~~~~~~~.....................#___U____................................",
//				"~~~~~~~~~~~~......................#_____K_#....nnnn........................",
//				"~~~~~~~~~~~.......................###___###................................",
//				"~~~~~~~~~~..........................#___#..................................",
//				"...........................................................................",
//				"...........................................................................",
//				"...........................................................................",
//				"..####__##...........................................&&&......######..##...",
//				"..#.....__...........................................&&&......#....____....",
//				"..#___..............&&&..............................&&&........__.....#...",
//				"..####__###.........&&&......................................._.....__.#...",
//				"....................&&&.......................................###..__###...",
//				"..........................................................................."
//		);
		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);
		int xRand = RandomNumberGenerator.getRandomInt(1, 74);
		int yRand = RandomNumberGenerator.getRandomInt(1, 22);
		if(xRand < 75/2){
			gameMap.at(xRand, yRand).setGround(new Graveyard(westFactory));
			gameMap.at(xRand + 1, yRand).setGround(new Graveyard(westFactory));
			gameMap.at(xRand, yRand + 1).setGround(new Graveyard(westFactory));
			gameMap.at(xRand + 1, yRand + 1).setGround(new Graveyard(westFactory));
		}
		else{
			gameMap.at(xRand, yRand).setGround(new Graveyard(eastFactory));
			gameMap.at(xRand + 1, yRand).setGround(new Graveyard(eastFactory));
			gameMap.at(xRand, yRand + 1).setGround(new Graveyard(eastFactory));
			gameMap.at(xRand + 1, yRand + 1).setGround(new Graveyard(eastFactory));
		}

		int xxRand = RandomNumberGenerator.getRandomInt(1, 75);
		int yyRand = RandomNumberGenerator.getRandomInt(1, 23);
		if(xRand < 75/2){
			gameMap.at(xxRand, yyRand).setGround(new PuddleOfWater(westFactory));
		}
		else{
			gameMap.at(xxRand, yyRand).setGround(new PuddleOfWater(eastFactory));
		}

		int x_Rand = RandomNumberGenerator.getRandomInt(1, 75);
		int y_Rand = RandomNumberGenerator.getRandomInt(1, 23);
		if(xRand < 75/2){
			gameMap.at(x_Rand, y_Rand).setGround(new GustOfWind(westFactory));
		}
		else{
			gameMap.at(x_Rand, y_Rand).setGround(new GustOfWind(eastFactory));
		}

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}



		gameMap.at(23, 17).addActor(new GiantCrayfish());
		//tester below
		gameMap.at(35, 10).addActor(new LoneWolf());
//		gameMap.at(37, 10).addActor(new LoneWolf());

		gameMap.at(37,10).addActor(new MerchantKale());
		// HINT: what does it mean to prefer composition to inheritance?
		Player player = new Player("Tarnished", '@', 300);

		//Select Combat Class
		Action classAction = new CombatClassMenu(player).showMenu();
		System.out.println(classAction.execute(player, gameMap));

		world.addPlayer(player, gameMap.at(24, 17));
		world.run();
	}
}
