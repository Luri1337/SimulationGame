package Entities;

import Utils.Coordinates;
import Utils.CoordinatesShift;
import Utils.GameMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Herbivore extends Creature {

    public Herbivore(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
    }
    public Herbivore() {}


    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return map.getEntity(coordinates).getClass() != Predator.class
                && map.getEntity(coordinates).getClass() != Rock.class
                && map.getEntity(coordinates).getClass() != Tree.class
                && map.getEntity(coordinates).getClass() != Herbivore.class;
    }

    @Override
    public Creature eat(GameMap map) {
        for (Coordinates neighbor : getAvailableMoves(map)) {
            Entity entity = map.getEntity(neighbor);
            if (entity != null && canEat(entity)) {
                this.hp += 25;
                entity.hp -= 100;
                map.generateNewFood();
                map.moveEntity(this.coordinates, entity.coordinates);
                this.hasMoved = true;
                return this;
            }
        }
        return this;
    }

    @Override
    boolean canEat(Entity entity) {
        return entity instanceof Grass;
    }
}
