package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.combatclass.CombatClassMenu;
import game.enemies.GiantCrab;
import game.enemies.LoneWolf;
import game.enemies.SkeletalBandit;
import game.environments.*;
import game.trading.MerchantKale;
import game.utils.RandomNumberGenerator;
import game.weapons.Scimitar;

import java.util.Arrays;
import java.util.List;


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
	private static WeaponItem club = new Scimitar();
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

		for(int i = 0; i <= 1; i++){
		int xRand = RandomNumberGenerator.getRandomInt(1, 74);
		int yRand = RandomNumberGenerator.getRandomInt(1, 22);
		if(xRand < 75/2){
			gameMap.at(xRand, yRand).setGround(new Graveyard(westFactory));
			gameMap.at(xRand + 1, yRand).setGround(new Graveyard(westFactory));
			gameMap.at(xRand, yRand + 1).setGround(new Graveyard(westFactory));
			gameMap.at(xRand + 1, yRand + 1).setGround(new Graveyard(westFactory));
		}
		else {
			gameMap.at(xRand, yRand).setGround(new Graveyard(eastFactory));
			gameMap.at(xRand + 1, yRand).setGround(new Graveyard(eastFactory));
			gameMap.at(xRand, yRand + 1).setGround(new Graveyard(eastFactory));
			gameMap.at(xRand + 1, yRand + 1).setGround(new Graveyard(eastFactory));
		}
		xRand = RandomNumberGenerator.getRandomInt(1, 74);
		yRand = RandomNumberGenerator.getRandomInt(1, 22);
		if(xRand < 75/2){
			gameMap.at(xRand, yRand).setGround(new PuddleOfWater(westFactory));
			gameMap.at(xRand + 1, yRand).setGround(new PuddleOfWater(westFactory));
			gameMap.at(xRand, yRand + 1).setGround(new PuddleOfWater(westFactory));
			gameMap.at(xRand + 1, yRand + 1).setGround(new PuddleOfWater(westFactory));
		}
		else {
			gameMap.at(xRand, yRand).setGround(new PuddleOfWater(eastFactory));
			gameMap.at(xRand + 1, yRand).setGround(new PuddleOfWater(eastFactory));
			gameMap.at(xRand, yRand + 1).setGround(new PuddleOfWater(eastFactory));
			gameMap.at(xRand + 1, yRand + 1).setGround(new PuddleOfWater(eastFactory));
		}
		xRand = RandomNumberGenerator.getRandomInt(1, 74);
		yRand = RandomNumberGenerator.getRandomInt(1, 22);
		if(xRand < 75/2){
			gameMap.at(xRand, yRand).setGround(new GustOfWind(westFactory));
			gameMap.at(xRand + 1, yRand).setGround(new GustOfWind(westFactory));
			gameMap.at(xRand, yRand + 1).setGround(new GustOfWind(westFactory));
			gameMap.at(xRand + 1, yRand + 1).setGround(new GustOfWind(westFactory));
		}
		else {
			gameMap.at(xRand, yRand).setGround(new GustOfWind(eastFactory));
			gameMap.at(xRand + 1, yRand).setGround(new GustOfWind(eastFactory));
			gameMap.at(xRand, yRand + 1).setGround(new GustOfWind(eastFactory));
			gameMap.at(xRand + 1, yRand + 1).setGround(new GustOfWind(eastFactory));
		}
		}



//
//		int xxRand = RandomNumberGenerator.getRandomInt(1, 72);
//		int yyRand = RandomNumberGenerator.getRandomInt(1, 20);
//		if(xRand < 72/2){
//
//			for(int i = 0; i < 5; i++) {
//				for (int j = 3; j > -1; j--) {
//					gameMap.at(xxRand - i - j, yyRand + j).setGround(new PuddleOfWater(eastFactory));
//				}
//			}
//		}
//		else{
//			for(int i = 0; i < 5; i++){
//				for(int j = 3; i > -1; i--){
//					gameMap.at(xxRand - i - j, yyRand + j).setGround(new PuddleOfWater(eastFactory));
//				}
//			}
//		}
//
//
//		int x_Rand = RandomNumberGenerator.getRandomInt(1, 68);
//
//		int y_Rand = RandomNumberGenerator.getRandomInt(1, 19);
//		if(xRand < 68/2){
//
//			for(int i = 0; i < 3; i++) {
//				for (int j = 3; j > -1; j--) {
//					gameMap.at(x_Rand + i + j, y_Rand + j).setGround(new GustOfWind(eastFactory));
//				}
//			}
//		}
//		else{
//			for(int i = 0; i < 5; i++){
//				for(int j = 3; i > -1; i--){
//					gameMap.at(x_Rand + i + j, y_Rand + j).setGround(new GustOfWind(eastFactory));
//				}
//			}
//		}

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		SkeletalBandit testWolf = new SkeletalBandit();

		gameMap.at(40, 17).addActor(testWolf);
//
//		ResetManager resetManager = ResetManager.getInstance();
//		resetManager.registerResettable(testWolf, testWolf);

		//tester below
		//gameMap.at(35, 10).addActor(new LoneWolf());
//		gameMap.at(37, 10).addActor(new LoneWolf());

		gameMap.at(35, 10).addActor(new GiantCrab());
		gameMap.at(34, 10).addActor(new LoneWolf());
//		gameMap.at(25, 23).addActor(new LoneWolf());
		gameMap.at(24, 22).addActor(new LoneWolf());
//		gameMap.at(26, 22).addActor(new LoneWolf());
		gameMap.at(37,10).addActor(new MerchantKale());

		Location LostGrace = gameMap.at(25, 20);
		gameMap.at(25, 20).setGround(new SiteOfLostGrace("The First Step", LostGrace));

		//Testing purposes only
		Location LostGrace2 = gameMap.at(23, 18);
		gameMap.at(23, 18).setGround(new SiteOfLostGrace("The Second Step", LostGrace2));

		gameMap.at(20, 20).setGround(new GustOfWind(eastFactory));

		// HINT: what does it mean to prefer composition to inheritance?
		Player player = new Player("Tarnished", '@', 300, LostGrace);
		player.addWeaponToInventory(club);
		//Select Combat Class
		Action classAction = new CombatClassMenu(player).showMenu();
		System.out.println(classAction.execute(player, gameMap));
		world.addPlayer(player, gameMap.at(25, 22));
		world.run();
	}
}
