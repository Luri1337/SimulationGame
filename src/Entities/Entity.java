package Entities;


import Utils.Coordinates;
import Utils.CoordinatesShift;
import Utils.GameMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Entity{
    public Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public Entity() {}

    public List<Coordinates> getAvailableMoves(GameMap map){
        List<Coordinates> result = new ArrayList<Coordinates>();
        for(CoordinatesShift shift : getEntityMoves()){
            if(coordinates.canShift(shift)){
                Coordinates newCoordinates = coordinates.shift(shift);
                if(isSquareAvailableForMove(newCoordinates, map)){
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }

    private boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return map.isSquareEmpty(coordinates);
    }


    public abstract Set<CoordinatesShift> getEntityMoves();

}
