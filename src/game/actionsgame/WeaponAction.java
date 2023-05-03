package game.actionsgame;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

// UNUSED CLASS
public abstract class WeaponAction extends Action {
    private Weapon weapon;
    private Actor target;
    private String direction;

    public WeaponAction(Weapon weapon){
        this.weapon = weapon;
    }
    public WeaponAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }
    @Override
    public abstract String execute(Actor actor, GameMap map);

    @Override
    public abstract String menuDescription(Actor actor);
}
