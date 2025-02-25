package entities;

import utils.Coordinates;
import utils.CoordinatesHandler;
import utils.GameBoard;

import java.util.*;

public abstract class Creature extends Entity {
    private boolean hasMoved;
    private Coordinates nextMove;
    private int hp;
    private Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Creature(Coordinates coordinates, int hp) {
        this.coordinates = coordinates;
        this.hp = hp;
        hasMoved = false;
    }

    public void move(Coordinates from, Coordinates to, GameBoard map) throws Exception {
        CoordinatesHandler.validateCoordinate(from, map);
        CoordinatesHandler.validateCoordinate(to, map);

        Creature entity = (Creature) map.getEntity(from);

        if(entity.getAvailableMoves(map).contains(to)){
            map.removeEntity(from);
            map.removeEntity(to);
            map.put(to, entity);
            entity.hasMoved = true;
            entity.setCoordinates(to);
        }
    }

    public Set<Coordinates> getCreatureMoves(){
        return new HashSet<>(Arrays.asList(
                new Coordinates(1 ,0),
                new Coordinates(-1, 0),
                new Coordinates(0, 1),
                new Coordinates(0, -1)
        ));
    }

    public List<Coordinates> getAvailableMoves(GameBoard map) throws Exception {
        List<Coordinates> result = new ArrayList<>();
        for(Coordinates shift : getCreatureMoves()){
            if(CoordinatesHandler.canShift(coordinates, shift, map)){
                Coordinates newCoordinates = coordinates.add(shift);
                if(isSquareAvailableForMove(newCoordinates, map)){
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }

    protected abstract boolean isSquareAvailableForMove(Coordinates coordinates, GameBoard map) throws Exception;

    abstract public void eat(GameBoard map) throws Exception;

    public abstract EntityType getTargetType();
    public boolean isHasMoved() {
        return hasMoved;
    }
    public Coordinates getNextMove() {
        return nextMove;
    }

    public int getHp() {
        return hp;
    }

    public void setNextMove(Coordinates nextMove) {
        this.nextMove = nextMove;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}
