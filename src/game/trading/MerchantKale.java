package game.trading;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.actionsgame.PurchaseAction;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Scimitar;
import game.weapons.Uchigatana;

public class MerchantKale extends Actor {
    private Player player;
    public MerchantKale(){

        super("MerchantKale", 'K', 1000);
        addCapability(TradingCapability.TRADE);
    }
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display)
    {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new PurchaseAction(otherActor, new Uchigatana(), new Uchigatana()));
        actions.add(new PurchaseAction(otherActor, new Club(), new Club()));
        actions.add(new PurchaseAction(otherActor, new GreatKnife(), new GreatKnife()));
        actions.add(new PurchaseAction(otherActor, new Scimitar(), new Scimitar()));

        return actions;
    }

}
