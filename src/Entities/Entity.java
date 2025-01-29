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
    int hp;

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

    public List<Coordinates> getNeighbors(Coordinates position){
        List<Coordinates> neighbors = new ArrayList<>();
        CoordinatesShift[] direction = {new CoordinatesShift(0,1 ), new CoordinatesShift(1,0),
                new CoordinatesShift(0,-1 ), new CoordinatesShift(-1,0)};

        for(CoordinatesShift dir : direction) {
            if(position.canShift(dir)){
                Coordinates neighbor = position.shift(dir);
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }

    private boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map) {
        return map.isSquareEmpty(coordinates);
    }


    public abstract Set<CoordinatesShift> getEntityMoves();


}
