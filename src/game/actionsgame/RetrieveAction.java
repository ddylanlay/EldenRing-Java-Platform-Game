package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.trading.OLD_Runes;
import game.trading.RunesManager;

public class RetrieveAction extends Action{
    private OLD_Runes OLDRunes;
    RunesManager runesManager = RunesManager.getInstance();

    public RetrieveAction(OLD_Runes OLDRunes){
        this.OLDRunes = OLDRunes;
    }
    @Override
    public String execute(Actor actor, GameMap map) {

        runesManager.playerRetrieveDroppedRunes(actor);

        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " retrieves Runes (value: " + OLDRunes.getNumOfRunes() + ")";
    }

}
