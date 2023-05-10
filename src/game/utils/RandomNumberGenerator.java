package game.utils;

import game.combatclass.*;

import java.util.Random;

/**
 * A random number generator
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class RandomNumberGenerator {
    public static int getRandomInt(int bound) {
        return bound > 0 ? new Random().nextInt(bound) : 0;
    }

    public static int getRandomInt(int lowerBound, int upperBound) {
        int range = upperBound - lowerBound + 1;
        return new Random().nextInt(range) + lowerBound;
    }
    public static CombatClass getRandomCombatClass(){
        int number = getRandomInt(100);

        if(number <= 25){
            return new Bandit();
        } else if (number <= 50) {
            return new Samurai();

        } else if(number <= 75){
            return new Wretch();
        } else if(number <= 100){
            return new Astrologer();
        }
        return new Bandit();
    }
}
