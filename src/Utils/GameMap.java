package Utils;

import Entities.*;

import java.util.HashMap;
import java.util.Random;

public class GameMap {
     private static final int MAP_WIDTH = 8;
     private static final int MAP_HEIGHT = 8;
     private final HashMap<Coordinates, Entity> map = new HashMap<>();

     public HashMap<Coordinates, Entity> getMap() {
          return map;
     }

     public void setEntity(Entity entity, Coordinates coordinates) {
          entity.coordinates = coordinates;
          map.put(coordinates, entity);
     }
     public void setupEntitiesStartPositions(){
          randomPlaceEntities(new Herbivore(), 5);
          randomPlaceEntities(new Predator(), 5);
     }
     public void randomPlaceEntities(Entity entity, int amount) {
          Random random = new Random();
          int placed = 0;

          while(placed < amount){
               int x = random.nextInt(MAP_WIDTH);
               int y = random.nextInt(MAP_HEIGHT);
               Coordinates coordinates = new Coordinates(x, y);

               if(isSquareEmpty(coordinates)){
                    Entity newEntity = entity.clone();
                    setEntity(newEntity, coordinates);
                    placed++;
               }
          }
     }

     public boolean isSquareEmpty(Coordinates coordinates) {
          return map.containsKey(coordinates);
     }

     public static boolean isSquareDark(Coordinates coordinates) {
          return ((coordinates.x + coordinates.y) % 2) == 0;
     }

}
