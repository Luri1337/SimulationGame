package entities;

import utils.Coordinates;
import utils.GameMap;

public abstract class Creature extends Entity {
    public boolean hasMoved;
    int speed;
    public Coordinates nextMove;


    public Creature(Coordinates coordinates, int speed, int hp) {
        super(coordinates);
        this.speed = speed;
        this.hp = hp;
        hasMoved = false;
    }
    public Creature(){}

    protected abstract boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map);
    abstract public Creature eat(GameMap map);
    abstract boolean canEat(Entity entity);
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}
