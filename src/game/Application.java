package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.combatclass.CombatClassMenu;
import game.enemies.*;
import game.environments.*;
import game.items.GoldenRunes;
import game.items.RemembranceOfGrafted;
import game.trading.FingerReaderEnia;
import game.trading.MerchantKale;
import game.utils.RandomNumberGenerator;
import game.weapons.Club;

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
	private static NorthEastFactory northEastFactory = new NorthEastFactory();
	private static NorthWestFactory northWestFactory = new NorthWestFactory();
	private static SouthEastFactory southEastFactory= new SouthEastFactory();
	private static SouthWestFactory southWestFactory = new SouthWestFactory();

	private static WeaponItem club = new Club();
	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Cliff(), new SummonSign(), new Barrack(), new Cage());
//set ground

		List<String> theLimgraveMap = Arrays.asList(
				"......................#.............#..........................+++.........",
				"......................#.............#.......................+++++..........",
				"......................#..___....____#.........................+++++........",
				"......................#...........__#............................++........",
				"......................#_____........#.............................+++......",
				"......................#............_#..............................+++.....",
				"......................######...######......................................",
				"...........................................................................",
				"...........................=...............................................",
				"........++++......................###___###................................",
				"........+++++++...................________#................................",
				"..........+++.....................#________................................",
				"............+++...................#_______#................................",
				".............+....................###___###................................",
				"............++......................#___#..................................",
				"..............+...................=........................................",
				"..............++.................................................=.........",
				"..............................................++...........................",
				"..................++++......................+++...............######..##...",
				"#####___######....++...........................+++............#....____....",
				"_____________#.....++++..........................+..............__.....#...",
				"_____________#.....+....++........................++.........._.....__.#...",
				"_____________#.........+..+.....................+++...........###..__###...",
				"_____________#.............++..............................................");

		List<String> theStormveilCastleMap = Arrays.asList(
		        "...........................................................................",
				"..................<...............<........................................",
				"...........................................................................",
				"##############################################...##########################",
				"............................#................#.......B..............B......",
				".....B...............B......#................#.............................",
				"...............................<.........<.................................",
				".....B...............B......#................#.......B..............B......",
				"............................#................#.............................",
				"#####################..#############...############.####..#########...#####",
				"...............#++++++++++++#................#++++++++++++#................",
				"...............#++++++++++++...<.........<...#++++++++++++#................",
				"...............#++++++++++++..................++++++++++++#................",
				"...............#++++++++++++#................#++++++++++++#................",
				"#####...##########.....#############...#############..#############...#####",
				".._______........................B......B........................B.....B...",
				"_____..._..____..............<..............<..............................",
				".........____..............................................................",
				"...._______..................<..............<....................<.....<...",
				"#####....##...###..#####...##########___###############......##.....####...",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++");
		List<String> theRoundTableHoldMap = Arrays.asList(
				"##################",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"########___#######");
		List<String> theBossRoomMap = Arrays.asList(
				"+++++++++++++++++++++++++",
				".........................",
				"..=......................",
				".........................",
				".........................",
				".........................",
				".........................",
				".........................",
				"+++++++++++++++++++++++++");

		GameMap limeGrave = new GameMap(groundFactory, theLimgraveMap);
		GameMap stormVeilCastle = new GameMap(groundFactory, theStormveilCastleMap);
		GameMap roundTableHold = new GameMap(groundFactory, theRoundTableHoldMap);
		GameMap bossRoom = new GameMap(groundFactory, theBossRoomMap);
		world.addGameMap(limeGrave);
		world.addGameMap(stormVeilCastle);
		world.addGameMap(roundTableHold);
		world.addGameMap(bossRoom);

		for(int i = 0; i <= 1; i++){
		int xRand = RandomNumberGenerator.getRandomInt(1, 73);
		int yRand = RandomNumberGenerator.getRandomInt(1, 22);
		if(xRand < 75/2 && yRand < 75/2){
			limeGrave.at(xRand, yRand).setGround(new Graveyard(southWestFactory));
			limeGrave.at(xRand + 1, yRand).setGround(new Graveyard(southWestFactory));
			limeGrave.at(xRand, yRand + 1).setGround(new Graveyard(southWestFactory));
			limeGrave.at(xRand + 1, yRand + 1).setGround(new Graveyard(southWestFactory));
		}
		else if(xRand > 75/2 && yRand > 75/2) {
			limeGrave.at(xRand, yRand).setGround(new Graveyard(northEastFactory));
			limeGrave.at(xRand + 1, yRand).setGround(new Graveyard(northEastFactory));
			limeGrave.at(xRand, yRand + 1).setGround(new Graveyard(northEastFactory));
			limeGrave.at(xRand + 1, yRand + 1).setGround(new Graveyard(northEastFactory));
		}
		else if(xRand > 75/2 && yRand < 75/2) {
			limeGrave.at(xRand, yRand).setGround(new Graveyard(southEastFactory));
			limeGrave.at(xRand + 1, yRand).setGround(new Graveyard(southEastFactory));
			limeGrave.at(xRand, yRand + 1).setGround(new Graveyard(southEastFactory));
			limeGrave.at(xRand + 1, yRand + 1).setGround(new Graveyard(southEastFactory));
		}
		else if(xRand < 75/2 && yRand > 75/2) {
			limeGrave.at(xRand, yRand).setGround(new Graveyard(northWestFactory));
			limeGrave.at(xRand + 1, yRand).setGround(new Graveyard(northWestFactory));
			limeGrave.at(xRand, yRand + 1).setGround(new Graveyard(northWestFactory));
			limeGrave.at(xRand + 1, yRand + 1).setGround(new Graveyard(northWestFactory));
		}
		xRand = RandomNumberGenerator.getRandomInt(1, 73);
		yRand = RandomNumberGenerator.getRandomInt(1, 22);
			if(xRand < 75/2 && yRand < 75/2){
				limeGrave.at(xRand, yRand).setGround(new PuddleOfWater(southWestFactory));
				limeGrave.at(xRand + 1, yRand).setGround(new PuddleOfWater(southWestFactory));
				limeGrave.at(xRand, yRand + 1).setGround(new PuddleOfWater(southWestFactory));
				limeGrave.at(xRand + 1, yRand + 1).setGround(new PuddleOfWater(southWestFactory));
			}
			else if(xRand > 75/2 && yRand > 75/2) {
				limeGrave.at(xRand, yRand).setGround(new PuddleOfWater(northEastFactory));
				limeGrave.at(xRand + 1, yRand).setGround(new PuddleOfWater(northEastFactory));
				limeGrave.at(xRand, yRand + 1).setGround(new PuddleOfWater(northEastFactory));
				limeGrave.at(xRand + 1, yRand + 1).setGround(new PuddleOfWater(northEastFactory));
			}
			else if(xRand > 75/2 && yRand < 75/2) {
				limeGrave.at(xRand, yRand).setGround(new PuddleOfWater(southEastFactory));
				limeGrave.at(xRand + 1, yRand).setGround(new PuddleOfWater(southEastFactory));
				limeGrave.at(xRand, yRand + 1).setGround(new PuddleOfWater(southEastFactory));
				limeGrave.at(xRand + 1, yRand + 1).setGround(new PuddleOfWater(southEastFactory));
			}
			else if(xRand < 75/2 && yRand > 75/2) {
				limeGrave.at(xRand, yRand).setGround(new PuddleOfWater(northWestFactory));
				limeGrave.at(xRand + 1, yRand).setGround(new PuddleOfWater(northWestFactory));
				limeGrave.at(xRand, yRand + 1).setGround(new PuddleOfWater(northWestFactory));
				limeGrave.at(xRand + 1, yRand + 1).setGround(new PuddleOfWater(northWestFactory));
			}

		xRand = RandomNumberGenerator.getRandomInt(1, 73);
		yRand = RandomNumberGenerator.getRandomInt(1, 22);
			if(xRand < 75/2 && yRand < 75/2){
				limeGrave.at(xRand, yRand).setGround(new GustOfWind(southWestFactory));
				limeGrave.at(xRand + 1, yRand).setGround(new GustOfWind(southWestFactory));
				limeGrave.at(xRand, yRand + 1).setGround(new GustOfWind(southWestFactory));
				limeGrave.at(xRand + 1, yRand + 1).setGround(new GustOfWind(southWestFactory));
			}
			else if(xRand > 75/2 && yRand > 75/2) {
				limeGrave.at(xRand, yRand).setGround(new GustOfWind(northEastFactory));
				limeGrave.at(xRand + 1, yRand).setGround(new GustOfWind(northEastFactory));
				limeGrave.at(xRand, yRand + 1).setGround(new GustOfWind(northEastFactory));
				limeGrave.at(xRand + 1, yRand + 1).setGround(new GustOfWind(northEastFactory));
			}
			else if(xRand > 75/2 && yRand < 75/2) {
				limeGrave.at(xRand, yRand).setGround(new GustOfWind(southEastFactory));
				limeGrave.at(xRand + 1, yRand).setGround(new GustOfWind(southEastFactory));
				limeGrave.at(xRand, yRand + 1).setGround(new GustOfWind(southEastFactory));
				limeGrave.at(xRand + 1, yRand + 1).setGround(new GustOfWind(southEastFactory));
			}
			else if(xRand < 75/2 && yRand > 75/2) {
				limeGrave.at(xRand, yRand).setGround(new GustOfWind(northWestFactory));
				limeGrave.at(xRand + 1, yRand).setGround(new GustOfWind(northWestFactory));
				limeGrave.at(xRand, yRand + 1).setGround(new GustOfWind(northWestFactory));
				limeGrave.at(xRand + 1, yRand + 1).setGround(new GustOfWind(northWestFactory));
			}
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


		limeGrave.at(38,8).addActor(new Dog());
		limeGrave.at(39,8).addActor(new GodrickSoldier());
		limeGrave.at(38,7).addActor(new Dog());
		limeGrave.at(37,10).addActor(new MerchantKale());
		limeGrave.at(41,10).addActor(new FingerReaderEnia());

		limeGrave.at(38, 11).addItem(new GoldenRunes());
		limeGrave.at(39, 10).addItem(new RemembranceOfGrafted());

		Location LostGrace = limeGrave.at(38, 12);
		limeGrave.at(38, 12).setGround(new SiteOfLostGrace("The First Step", LostGrace));



		// adds Golden Fog Door to the necessary game maps
		limeGrave.at(40,10).setGround(new GoldenFogDoor("Roundtable Hold",roundTableHold.at(10,5)));
		limeGrave.at(36,12).setGround(new GoldenFogDoor("Stormveil Castle",stormVeilCastle.at(35,10)));

		stormVeilCastle.at(36,9).setGround(new GoldenFogDoor("Limgrave",limeGrave.at(35,12)));
		stormVeilCastle.at(37, 9).setGround(new GoldenFogDoor("boss room", bossRoom.at(10,5)));

		roundTableHold.at(8,6).setGround(new GoldenFogDoor("Limgrave", limeGrave.at(35,12)));

		stormVeilCastle.at(20,16).setGround(new GustOfWind(northWestFactory));
		stormVeilCastle.at(20,17).setGround(new GustOfWind(northWestFactory));
		stormVeilCastle.at(21,16).setGround(new GustOfWind(northWestFactory));
		stormVeilCastle.at(21,17).setGround(new GustOfWind(northWestFactory));


		// HINT: what does it mean to prefer composition to inheritance?
		Player player = new Player("Tarnished", '@', 300, LostGrace);

		//Select Combat Class
		Action classAction = new CombatClassMenu(player).showMenu();
		System.out.println(classAction.execute(player, limeGrave));
		world.addPlayer(player, limeGrave.at(36, 10));

		//FOR TESTING REMOVE BEFORE MERGE
//		world.addPlayer(player, limeGrave.at(43, 11));
//		limeGrave.at(43,12).addActor(new GodrickSoldier());

		world.run();
	}
}
