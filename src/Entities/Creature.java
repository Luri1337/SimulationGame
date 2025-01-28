package Entities;

import Utils.Coordinates;
import Utils.GameMap;

public abstract class Creature extends Entity {
    public boolean hasMoved;
    int speed;
    int hp;

    public Creature(Coordinates coordinates, int speed, int hp) {
        super(coordinates);
        this.speed = speed;
        this.hp = hp;
        hasMoved = false;
    }
    public Creature(){}

    protected abstract boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map);
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}
