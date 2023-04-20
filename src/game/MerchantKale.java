package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class MerchantKale extends Actor implements Runes {
    public MerchantKale(String name, char displayChar, int hitPoints){
        super(name, displayChar, hitPoints);

    }

    public ActionList getAllowActions(Actor otherActor, String direction, GameMap map){
       ActionList actions = new ActionList();
       actions.add()
    }
}
