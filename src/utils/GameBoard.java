package utils;

import entities.Entity;

import java.util.*;

public class GameBoard {
    private final int MAP_WIDTH;
    private final int MAP_HEIGHT;

    private final int initialGrassCount;
    private int currentGrassCount;

    private final int initialHerbivoreCount;
    private int currentHerbivoreCount;

    private final Map<Coordinates, Entity> entities = new HashMap<>();

    public GameBoard(int MAP_WIDTH, int MAP_HEIGHT, int initialFoodCount, int initialHerbivoreCount) {
        this.MAP_WIDTH = MAP_WIDTH;
        this.MAP_HEIGHT = MAP_HEIGHT;
        this.initialGrassCount = initialFoodCount;
        this.currentGrassCount = initialFoodCount;
        this.initialHerbivoreCount = initialHerbivoreCount;
        this.currentHerbivoreCount = initialHerbivoreCount;
    }

    public void put(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) throws Exception {
        CoordinatesHandler.validateCoordinate(coordinates, this);

        if (entities.get(coordinates) == null) {
            throw new Exception("Object not found");
        } else {
            return entities.get(coordinates);
        }
    }

    public Coordinates getCoordinates(Entity entity) {
        for (Map.Entry<Coordinates, Entity> entry : entities.entrySet()) {
            if (Objects.equals(entry.getValue(), entity)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public boolean isSquareEmpty(Coordinates coordinates) throws Exception {
        CoordinatesHandler.validateCoordinate(coordinates, this);
        return entities.get(coordinates) == null;
    }

    public boolean contains(Entity entity){
        for (Map.Entry<Coordinates, Entity> entry : entities.entrySet()) {
            if (Objects.equals(entry.getValue(), entity)) {
                return true;
            }
        }
        return false;
    }

    public void removeEntity(Coordinates coordinates) throws Exception {
        CoordinatesHandler.validateCoordinate(coordinates, this);
        entities.remove(coordinates);
    }

    public List<Entity> getAllEntities() {
        List<Entity> entityList = new ArrayList<>();
        for (int y = getMAP_HEIGHT() - 1; y >= 0; y--) {
            for (int x = 0; x < getMAP_WIDTH(); x++) {
                if (entities.get(new Coordinates(x, y)) != null) {
                    entityList.add(entities.get(new Coordinates(x, y)));
                }
            }
        }
        return entityList;
    }

    public int getMAP_WIDTH() {
        return MAP_WIDTH;
    }

    public int getMAP_HEIGHT() {
        return MAP_HEIGHT;
    }

    public int getInitialGrassCount() {
        return initialGrassCount;
    }

    public void setCurrentGrassCount(int currentGrassCount) {
        this.currentGrassCount = currentGrassCount;
    }

    public int getCurrentGrassCount() {
        return currentGrassCount;
    }

    public void setCurrentHerbivoreCount(int currentHerbivoreCount) {
        this.currentHerbivoreCount = currentHerbivoreCount;
    }

    public int getCurrentHerbivoreCount() {
        return currentHerbivoreCount;
    }

    public int getInitialHerbivoreCount() {
        return initialHerbivoreCount;
    }
}
