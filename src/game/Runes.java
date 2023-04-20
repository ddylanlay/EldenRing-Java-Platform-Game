package game;

import edu.monash.fit2099.engine.actors.Actor;

public interface Runes {
    boolean removeRunes(int totalRunes, int runes);
    boolean addRunes(int totalRunes, int runes);
    void transferRunes(Actor target);
}
