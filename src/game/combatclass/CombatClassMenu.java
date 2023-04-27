package game.combatclass;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.displays.Display;
import game.Player;
import game.actionsgame.SelectCombatClassAction;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class that allows selection of the player combat class.
 *
 * Created by:
 * @author Dylan Lay
 *
 * Modified by:
 * @author Arosh Heenkenda
 *
 */
public class CombatClassMenu {

    /**
     * Array List of all the combat classes.
     */
    private ArrayList<CombatClass> classes = new ArrayList<CombatClass>() {

        {
            add(new Bandit());
            add(new Samurai());
            add(new Wretch());
        }
    };

    /**
     * The player.
     */
    private Player player;

    /**
     * Constructor
     *
     * @param _player the player.
     */
    public CombatClassMenu(Player _player){ this.player = _player; }

    /**
     * Display the menu and allow the player to select their combat class.
     *
     * @return Action that will allow player to select combat class and give the correct stats.
     */
    public Action showMenu(){

        Display display = new Display();
        HashMap<Character, Action> keyToActionMap = new HashMap<Character, Action>();
        ArrayList<SelectCombatClassAction> actions = new ArrayList<SelectCombatClassAction>();

        for (CombatClass combatclass : classes){

            actions.add(new SelectCombatClassAction(combatclass, player));
        }

        display.println("Select your role: ");
        // Show with the actions with hotkeys first;
        for (SelectCombatClassAction action : actions) {
            char c = action.getCombatClass().getDisplayChar();
            keyToActionMap.put(c, action);
            display.println(c + ": to choose the " + action.getCombatClass().getClassName() + " class.");
        }

        char key;
        do {
            key = display.readChar();
        } while (!keyToActionMap.containsKey(key));

        return keyToActionMap.get(key);

    }

}
