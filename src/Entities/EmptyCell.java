package Entities;

import Utils.Coordinates;
import Utils.CoordinatesShift;
import Utils.GameMap;

import java.util.Set;

public class EmptyCell extends Entity {

    public EmptyCell(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return true;
    }
}
