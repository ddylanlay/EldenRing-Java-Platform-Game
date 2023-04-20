package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.PurchaseAction;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;

public class MerchantKale extends Actor {
    public MerchantKale(String name, char displayChar, int hitPoints){
        super(name, displayChar, hitPoints);
    }
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display)
    {
        return new DoNothingAction();
    }

    public ActionList getAllowableActions(Actor otherActor, String direction, GameMap map){
       ActionList actions = new ActionList();
       actions.add(new PurchaseAction(otherActor, new Uchigatana()));
       actions.add(new PurchaseAction(otherActor, new Club()));
       actions.add(new PurchaseAction(otherActor, new GreatKnife()));

       return actions;

    }
}
