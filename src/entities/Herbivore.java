package entities;

import utils.Coordinates;
import utils.GameMap;

public class Herbivore extends Creature {

    public Herbivore(Coordinates coordinates, int hp) {
        super(coordinates, hp);
    }

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
            if (canEat(entity)) {
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
