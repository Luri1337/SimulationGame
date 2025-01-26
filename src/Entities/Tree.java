package Entities;

import Utils.Coordinates;
import Utils.CoordinatesShift;

import java.util.Set;

public class Tree extends Entity {

    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public Set<CoordinatesShift> getEntityMoves() {
        return Set.of();
    }
}
