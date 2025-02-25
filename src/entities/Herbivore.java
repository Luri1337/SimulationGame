package entities;

import utils.Coordinates;
import utils.GameBoard;

public class Herbivore extends Creature {
    private static final int GRASS_HEAL_AMOUNT = 25;

    public Herbivore(Coordinates coordinates, int hp) {
        super(coordinates, hp);
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, GameBoard map) {
        try {
            Object entity = map.getEntity(coordinates);

            return entity.getClass() != Rock.class
                    && entity.getClass() != Tree.class
                    && entity.getClass() != Herbivore.class
                    && entity.getClass() != Predator.class;
        } catch (Exception e) {
            return e.getMessage().equals("Object not found");
        }
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.HERBIVORE;
    }

    @Override
    public void eat(GameBoard map) throws Exception {
        for (Coordinates neighbor : getAvailableMoves(map)) {
            try {
                Entity entity = map.getEntity(neighbor);
                if (entity.getEntityType() == EntityType.GRASS) {
                    Grass grass = (Grass) entity;
                    setHp(getHp() + GRASS_HEAL_AMOUNT);
                    this.move(getCoordinates(), map.getCoordinates(grass), map);
                    setHasMoved(true);
                    map.setCurrentGrassCount(map.getCurrentGrassCount() - 1);
                    return;
                }
            }catch (Exception e) {
                continue;
            }
        }
    }

    @Override
    public EntityType getTargetType() {
        return EntityType.GRASS;
    }
}
