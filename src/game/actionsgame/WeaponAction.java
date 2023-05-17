package game.actionsgame;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

// UNUSED CLASS
public abstract class WeaponAction extends Action {
    private WeaponItem weapon;
    private Actor target;


    public WeaponAction(WeaponItem weapon){
        this.weapon = weapon;
    }

    @Override
    public abstract String execute(Actor actor, GameMap map);

    @Override
    public abstract String menuDescription(Actor actor);
}
