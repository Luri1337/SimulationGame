package entities;

import utils.Coordinates;
import utils.GameMap;

public class Tree extends Entity {

    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return true;
    }

}
