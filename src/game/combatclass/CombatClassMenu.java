package game.combatclass;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import game.Player;
import game.actionsgame.SelectCombatClassAction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;


public class CombatClassMenu {

    private ArrayList<CombatClass> classes = new ArrayList<CombatClass>() {

        {
            add(new Bandit());
            add(new Samurai());
            add(new Wretch());
        }
    };

    private Player player;

    public CombatClassMenu(Player _player){
        this.player = _player;
    }


    public Action showMenu(){

        Display display = new Display();
        HashMap<Character, Action> keyToActionMap = new HashMap<Character, Action>();
        ArrayList<SelectCombatClassAction> actions = new ArrayList<SelectCombatClassAction>();

        for (CombatClass combatclass : classes){

            actions.add(new SelectCombatClassAction(combatclass, player));
        }

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
