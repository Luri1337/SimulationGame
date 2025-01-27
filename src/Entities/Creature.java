package Entities;

import Utils.Coordinates;
import Utils.GameMap;

public abstract class Creature extends Entity {
    int speed;
    int hp;

    public Creature(Coordinates coordinates, int speed, int hp) {
        super(coordinates);
        this.speed = speed;
        this.hp = hp;
    }
    public Creature(){}

    protected abstract boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map);
}
