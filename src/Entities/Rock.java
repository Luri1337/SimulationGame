package Entities;

import Utils.Coordinates;
import Utils.CoordinatesShift;

import java.util.Set;

public class Rock extends Entity {

    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public Set<CoordinatesShift> getEntityMoves() {
        return Set.of();
    }
}
