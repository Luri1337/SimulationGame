package Entities;

import Utils.Coordinates;
import Utils.CoordinatesShift;

import java.util.Set;

public class EmptyCell extends Entity{
    public EmptyCell(Coordinates coordinates) {
        super(coordinates);
    }
    @Override
    public Set<CoordinatesShift> getEntityMoves() {
        return null;
    }
}
