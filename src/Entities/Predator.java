package Entities;

import Utils.Coordinates;
import Utils.CoordinatesShift;
import Utils.GameMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Predator extends Creature {

    public Predator(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
    }

    public Predator() {}

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return map.getEntity(coordinates).getClass() != Rock.class
                || map.getEntity(coordinates).getClass() != Tree.class;
    }

    @Override
    public Set<CoordinatesShift> getEntityMoves() {
        return new HashSet<>(Arrays.asList(
                new CoordinatesShift(1 ,0),
                new CoordinatesShift(-1, 0),
                new CoordinatesShift(0, 1),
                new CoordinatesShift(0, -1)
        ));
    }
}
