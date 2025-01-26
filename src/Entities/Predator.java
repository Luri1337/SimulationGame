package Entities;

import Utils.Coordinates;
import Utils.CoordinatesShift;

import java.util.Set;

public class Predator extends Creature {

    public Predator(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
    }

    public Predator() {}

    @Override
    public Set<CoordinatesShift> getEntityMoves() {
        return Set.of();
    }
}
