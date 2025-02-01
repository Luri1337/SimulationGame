package entities;

import utils.Coordinates;
import utils.GameMap;

public class Rock extends Entity {

    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return true;
    }
}
