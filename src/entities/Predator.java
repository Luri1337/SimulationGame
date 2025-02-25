package entities;

import utils.Coordinates;
import utils.GameBoard;

public class Predator extends Creature {
    private static final int HERBIVORE_DAMAGE_AMOUNT = 100;

    public Predator(Coordinates coordinates, int hp) {
        super(coordinates, hp);
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, GameBoard map) {
        try {
            Object entity = map.getEntity(coordinates);

            return entity.getClass() != Rock.class
                    && entity.getClass() != Tree.class
                    && entity.getClass() != Grass.class
                    && entity.getClass() != Predator.class;
        } catch (Exception e) {
            return e.getMessage().equals("Object not found");
        }
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.PREDATOR;
    }

    @Override
    public void eat(GameBoard map) throws Exception {
        for (Coordinates neighbor : getAvailableMoves(map)) {
            try{
                Entity entity = map.getEntity(neighbor);
                if (entity.getEntityType() == EntityType.HERBIVORE) {
                    Herbivore herb = (Herbivore) entity;
                    setHasMoved(true);
                    herb.setHp(herb.getHp() - HERBIVORE_DAMAGE_AMOUNT);
                    if(herb.getHp() <= 0) {
                        this.move(this.getCoordinates(), herb.getCoordinates(), map);
                        map.setCurrentHerbivoreCount(map.getCurrentHerbivoreCount() - 1);
                    }
                    return;
                }
            }catch(Exception e){
                continue;
            }
        }
    }

    @Override
    public EntityType getTargetType() {
        return EntityType.HERBIVORE;
    }
}
