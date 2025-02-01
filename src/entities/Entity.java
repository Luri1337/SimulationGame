package entities;


import utils.Coordinates;
import utils.CoordinatesShift;
import utils.GameMap;

import java.util.*;

public abstract class Entity{
    public Coordinates coordinates;
    int hp;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public Entity() {}

    public List<Coordinates> getAvailableMoves(GameMap map){
        List<Coordinates> result = new ArrayList<>();
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

     abstract boolean isSquareAvailableForMove(Coordinates coordinates, GameMap map);

    public Set<CoordinatesShift> getEntityMoves(){
        return new HashSet<>(Arrays.asList(
                new CoordinatesShift(1 ,0),
                new CoordinatesShift(-1, 0),
                new CoordinatesShift(0, 1),
                new CoordinatesShift(0, -1)
        ));
    }


}
