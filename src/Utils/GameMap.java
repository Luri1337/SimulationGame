package Utils;

import Entities.*;

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

     public void setupEntitiesStartPositions(){

          createEntity(EntityType.HERBIVORE, 3);
          createEntity(EntityType.PREDATOR, 3);
          createEntity(EntityType.ROCK, 1);
          createEntity(EntityType.TREE, 2);
          createEntity(EntityType.GRASS, 2);


     }

     private void fillMapWithEmptyCells() {
          for (int x = 1; x <= MAP_WIDTH; x++) {
               for (int y = 1; y <= MAP_HEIGHT; y++) {
                    if(isSquareEmpty(new Coordinates(x, y))) {
                         setEntity(new EmptyCell(new Coordinates(x, y)), new Coordinates(x, y));
                    }
               }
          }
     }


     private void createEntity(EntityType entityType ,int amount) {
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
                    case HERBIVORE -> entity = new Herbivore(coordinates, 1 , 100);
                    case PREDATOR -> entity = new Predator(coordinates, 1 , 100);
                    case GRASS -> entity = new Grass(coordinates);
                    case TREE -> entity = new Tree(coordinates);
                    case ROCK -> entity = new Rock(coordinates);
                    default -> entity = null;
               };
              setEntity(entity, coordinates);
              placed++;
          }
     }

     public void removeEntity(Coordinates coordinates) {
          map.remove(coordinates);
     }

     public void moveEntity(Coordinates from, Coordinates to) {
          Entity entity = getEntity(from);

          removeEntity(from);
          setEntity(entity, to);
     }

     public boolean isSquareEmpty(Coordinates coordinates) {
          return !map.containsKey(coordinates);
     }

     public static boolean isSquareDark(Coordinates coordinates) {
          return ((coordinates.x + coordinates.y) % 2) == 0;
     }

     public List<Creature> getAllCreatures() {
          List<Creature> creatures = new ArrayList<>();
          for (int y = 10; y >= 1 ; y--) {
               for (int x = 1; x <= 10 ; x++) {
                    if(map.get(new Coordinates(x, y)) instanceof Creature) {
                         creatures.add((Creature) map.get(new Coordinates(x, y)));
                    }
               }
          }
          return creatures;
     }
}
