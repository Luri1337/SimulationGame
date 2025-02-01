package entities;

import utils.Coordinates;
import utils.GameMap;

public class EmptyCell extends Entity {

    public EmptyCell(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return true;
    }
}
