package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.combatclass.CombatClass;

public class SelectCombatClassAction extends Action {

    CombatClass combatClass;

    public SelectCombatClassAction(CombatClass combatClass) {
        this.combatClass = combatClass;
    }
    public String displayCombatMenu(CombatClass combatClass) {
        return combatClass.getDisplayChar() + ": " + combatClass.toString();
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        return displayCombatMenu((CombatClass) actor);
    }

    public String menuDescription(Actor actor){
        return "Select your role: ";
    }

}
