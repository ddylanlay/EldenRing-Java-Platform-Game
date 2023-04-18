package game;

public class Runess {
    public boolean addRunes(int totalRunes, int runes){

    }
    public boolean removeRunes(int totalRunes, int runes){
        boolean isValid = false;
        if (totalRunes - runes >= 0)
        {
            isValid = true;
        }
        return isValid;
    }

    public static int enemyDrop(int low, int high){
        int num = RandomNumberGenerator.getRandomInt(low, high);
        return num;

    }

}
