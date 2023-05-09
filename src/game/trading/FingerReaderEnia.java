package game.trading;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actionsgame.PurchaseAction;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Scimitar;
import game.weapons.Uchigatana;

/**
 * Finger Reader Enia Trader
 *
 * Allows for normal selling and buying actions, as well as allowing Player
 *  to trade for Axe of Godrick and Grafted Dragon.
 */
public class FingerReaderEnia extends Actor {

    /**
     * Constructor
     */
    public FingerReaderEnia(){ super("Finger Reader Enia", 'E', 1000); }

    /**
     * Play the Trader Enia's turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * Gets the allowable actions for this trader.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
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
