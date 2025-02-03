package entities;

import utils.Coordinates;
import utils.GameMap;

public abstract class Creature extends Entity {
    public boolean hasMoved;
    public Coordinates nextMove;

    public Creature(Coordinates coordinates, int hp) {
        super(coordinates);
        this.hp = hp;
        hasMoved = false;
    }

    protected abstract boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map);
    abstract public Creature eat(GameMap map);
    abstract boolean canEat(Entity entity);
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}
