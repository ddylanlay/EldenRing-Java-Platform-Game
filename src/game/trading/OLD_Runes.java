package game.trading;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actionsgame.RetrieveAction;

public class OLD_Runes extends Ground{

    private int numOfRunes;
    private Ground originalGround;
    RunesManager runesManager = RunesManager.getInstance();

    public OLD_Runes(Actor actor, Ground originalGround) {
        super('$');
        this.originalGround = originalGround;
        numOfRunes = runesManager.retrieveActorsRunes(actor);
        runesManager.storeActorsRunes(actor, 0);
    }


    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
            ActionList actions = new ActionList();
            //actions.add(new RetrieveAction(this));
            return actions;
        }
    public Ground getOriginalGround() {
        return originalGround;
    }

    public int getNumOfRunes(){
        return numOfRunes;
    }

    public void retrievedByPlayer(Actor actor){
        runesManager.addRunes(actor, numOfRunes);
    }



}
