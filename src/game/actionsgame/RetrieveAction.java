package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.trading.Runes;
import game.trading.RunesManager;

public class RetrieveAction extends Action{
    private Runes runes;
    RunesManager runesManager = RunesManager.getInstance();

    public RetrieveAction(Runes runes){
        this.runes = runes;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
//        Location actorLocation = map.locationOf(actor);
//        int xLocation = actorLocation.x();
//        int yLocation = actorLocation.y();
//        runes.retrievedByPlayer(actor);
        runesManager.playerRetrieveDroppedRunes(actor);
//        for (int x = xLocation - 1; x <= xLocation + 1; x++) {
//            for (int y = yLocation - 1; y <= yLocation + 1; y++) {
//                Location tempLocation = map.at(x,y);
//                if (tempLocation.getGround() == runes) {
//                    tempLocation.setGround(runes.getOriginalGround());
//                }
//            }
//        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " retrieves Runes (value: " + runes.getNumOfRunes() + ")";
    }

}
