package game.trading;

import edu.monash.fit2099.engine.actors.Actor;

public interface Runes {
    int addRunes(int runes);
    int removeRunes(int runes);
    void transferRunes(Actor target);
}
