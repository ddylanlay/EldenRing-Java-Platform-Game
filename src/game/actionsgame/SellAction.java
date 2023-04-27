package game.actionsgame;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Player;
import game.trading.RunesManager;
import game.trading.SellableItem;

import java.util.ArrayList;

public class SellAction extends Action {
    private ArrayList<Actor> actorInRange = new ArrayList<>();
    private Player player;
    WeaponItem weapon;
    SellableItem sellWeapon;
    private Actor actor;
    RunesManager runesManager = RunesManager.getInstance();

    public SellAction(Actor target, WeaponItem weapon, SellableItem sellWeapon) {
        this.actor = target;
        this.weapon = weapon;
        this.sellWeapon = sellWeapon;
    }

    public void scanAround(Actor actor, GameMap map){
        Location actorLocation = map.locationOf(actor);
        int xLocation = actorLocation.x();
        int yLocation = actorLocation.y();

        for(int x = xLocation - 1; x <= xLocation + 1; x++){
            for(int y = yLocation - 1; y <= yLocation + 1; y++){
                Location tempLocation = new Location(map, x, y);
                if(map.isAnActorAt(tempLocation)){
                    if(xLocation != x && yLocation != y){
                        actorInRange.add(map.getActorAt(tempLocation));
                    }
                }
            }
        }
    }

    public void findMerchant(Actor actor, GameMap map) {
        for (Actor target : actorInRange) {
            if (target.toString() == "Merchant Kale") {

            }
        }
        actorInRange.clear();
    }
    public String sell( Actor actor, SellableItem sellWeapon, WeaponItem weapon) {

        runesManager.addRunes(actor, sellWeapon.getSellingPrice());
        player.removeWeaponFromInventory(weapon);
        return menuDescription(actor);

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return sell(actor, sellWeapon, weapon);
    }

    public String theMenuDescription(SellableItem weapon, Player player) {
        return player + " sells " + weapon + " for " + weapon.getSellingPrice();
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + sellWeapon + " for " + sellWeapon.getSellingPrice();
    }
}
