package utils;

import entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameMap {
    private static final int MAP_WIDTH = 10;
    private static final int MAP_HEIGHT = 10;
    private final HashMap<Coordinates, Entity> map = new HashMap<>();

    public HashMap<Coordinates, Entity> getMap() {
        return map;
    }

    public void setEntity(Entity entity, Coordinates coordinates) {
        entity.coordinates = coordinates;
        map.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public void setupEntitiesStartPositions() {
        fillMapWithEmptyCells();

        createEntity(EntityType.HERBIVORE, 5);
        createEntity(EntityType.PREDATOR, 5);
        createEntity(EntityType.ROCK, 10);
        createEntity(EntityType.TREE, 5);
        createEntity(EntityType.GRASS, 5);


    }

    private void createEntity(EntityType entityType, int amount) {
        Random random = new Random();
        int placed = 0;

        while (placed < amount) {
            int x = 1 + random.nextInt(MAP_WIDTH);
            int y = 1 + random.nextInt(MAP_HEIGHT);
            Coordinates coordinates = new Coordinates(x, y);

            if (!isSquareEmpty(coordinates)) {
                continue;
            }
            Entity entity;
            switch (entityType) {
                case HERBIVORE -> entity = new Herbivore(coordinates,100);
                case PREDATOR -> entity = new Predator(coordinates,100);
                case GRASS -> entity = new Grass(coordinates);
                case TREE -> entity = new Tree(coordinates);
                case ROCK -> entity = new Rock(coordinates);
                default -> entity = null;
            }

            setEntity(entity, coordinates);
            placed++;
        }
    }

    public void removeEntity(Coordinates coordinates) {
        map.remove(coordinates);
        map.put(coordinates, new EmptyCell(coordinates));
    }

    public void moveEntity(Coordinates from, Coordinates to) {
        Creature entity = (Creature) getEntity(from);

        if(entity.getAvailableMoves(this).contains(to)){
            removeEntity(from);
            setEntity(entity, to);
            entity.hasMoved = true;
        }
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return map.get(coordinates) instanceof EmptyCell;
    }

    public static boolean isSquareDark(Coordinates coordinates) {
        return ((coordinates.x + coordinates.y) % 2) == 0;
    }

    public List<Creature> getAllCreatures() {
        List<Creature> creatures = new ArrayList<>();
        for (int y = 10; y >= 1; y--) {
            for (int x = 1; x <= 10; x++) {
                if (map.get(new Coordinates(x, y)) instanceof Creature) {
                    creatures.add((Creature) map.get(new Coordinates(x, y)));
                }
            }
        }
        return creatures;
    }

    private void fillMapWithEmptyCells() {
        for (int x = 1; x <= MAP_WIDTH; x++) {
            for (int y = 1; y <= MAP_HEIGHT; y++) {
                setEntity(new EmptyCell(new Coordinates(x, y)), new Coordinates(x, y));
            }
        }
    }

    public void generateNewFood() {
        Random random = new Random();

        while (true) {

            int x = 1 + random.nextInt(MAP_WIDTH);
            int y = 1 + random.nextInt(MAP_HEIGHT);
            Coordinates coordinates = new Coordinates(x, y);

            if (isSquareEmpty(coordinates)) {
                map.put(coordinates, new Grass(coordinates));
                return;
            }
        }
    }

    public void generateNewHerbivore() {
        Random random = new Random();

        while (true) {

            int x = 1 + random.nextInt(MAP_WIDTH);
            int y = 1 + random.nextInt(MAP_HEIGHT);
            Coordinates coordinates = new Coordinates(x, y);

            if (isSquareEmpty(coordinates)) {
                Creature newHerbivore = new Herbivore(coordinates,100);
                newHerbivore.hasMoved = true;
                map.put(coordinates, newHerbivore);
                return;
            }
        }
    }
}
