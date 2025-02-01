package entities;

import utils.Coordinates;
import utils.GameMap;

public class Grass extends Entity{

    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return true;
    }
}
