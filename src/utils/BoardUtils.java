package utils;

import entities.*;

import java.util.Random;

public class BoardUtils {

    public void setupEntitiesStartPositions(GameBoard map) throws Exception {
        createEntity(map, EntityType.HERBIVORE, map.getInitialHerbivoreCount());
        createEntity(map, EntityType.PREDATOR, 3);
        createEntity(map, EntityType.ROCK, 5);
        createEntity(map, EntityType.TREE, 5);
        createEntity(map, EntityType.GRASS, map.getInitialGrassCount());
    }

    public void createEntity(GameBoard map, EntityType entityType, int amount) throws Exception {
        Random random = new Random();
        int placed = 0;

        while (placed < amount) {
            int x = random.nextInt(map.getMAP_WIDTH());
            int y = random.nextInt(map.getMAP_HEIGHT());
            Coordinates coordinates = new Coordinates(x, y);

            if (!map.isSquareEmpty(coordinates)) {
                continue;
            }
            Entity entity;
            switch (entityType) {
                case HERBIVORE -> entity = new Herbivore(coordinates,100);
                case PREDATOR -> entity = new Predator(coordinates,100);
                case GRASS -> entity = new Grass();
                case TREE -> entity = new Tree();
                case ROCK -> entity = new Rock();
                default -> entity = null;
            }

            map.put(coordinates, entity);
            placed++;
        }
    }

    public boolean isSquareDark(Coordinates coordinates, GameBoard map) throws Exception {
        CoordinatesHandler.validateCoordinate(coordinates, map);
        return ((coordinates.getX() + coordinates.getY()) % 2) == 0;
    }

}
