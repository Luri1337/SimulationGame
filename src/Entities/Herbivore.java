package Entities;

import Utils.Coordinates;
import Utils.CoordinatesShift;

import java.util.Set;

public class Herbivore extends Creature {

    public Herbivore(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
    }
    public Herbivore() {}

    @Override
    public Set<CoordinatesShift> getEntityMoves() {
        return Set.of();
    }
}
