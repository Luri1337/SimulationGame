package Entities;

import Utils.Coordinates;

public abstract class Creature extends Entity {
    int speed;
    int hp;

    public Creature(Coordinates coordinates, int speed, int hp) {
        super(coordinates);
        this.speed = speed;
        this.hp = hp;
    }
    public Creature(){}
}
