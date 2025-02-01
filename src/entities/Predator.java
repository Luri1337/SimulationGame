package entities;

import utils.Coordinates;
import utils.GameMap;

public class Predator extends Creature {

    public Predator(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return map.getEntity(coordinates).getClass() != Rock.class
                && map.getEntity(coordinates).getClass() != Tree.class
                && map.getEntity(coordinates).getClass() != Grass.class
                && map.getEntity(coordinates).getClass() != Predator.class;
    }

    @Override
    public Creature eat(GameMap map) {
        for (Coordinates neighbor : getAvailableMoves(map)) {
            Entity entity = map.getEntity(neighbor);
            if (entity != null && canEat(entity)) {
                this.hasMoved = true;
                entity.hp -= 100;
                if(entity.hp <= 0) {
                    map.removeEntity(entity.coordinates);
                    map.generateNewHerbivore();
                }
                return this;
            }
        }
        return this;
    }

    @Override
    boolean canEat(Entity entity) {
        return entity instanceof Herbivore;
    }
}
