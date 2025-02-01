package utils;

import entities.Creature;
import entities.Herbivore;
import entities.Predator;

import java.security.PublicKey;
import java.util.List;

public class Actions {

    public static void turnAction(GameMap map, BFS bfs) throws InterruptedException {
        for (int y = 10; y >= 1; y--) {
            for (int x = 1; x <= 10; x++) {
                if (map.getMap().get(new Coordinates(x, y)) instanceof Herbivore
                        || map.getMap().get(new Coordinates(x, y)) instanceof Predator) {

                    Coordinates currentPos = new Coordinates(x, y);
                    Creature currentEntity = (Creature) map.getEntity(currentPos);

                    if (currentEntity.hasMoved) {
                        continue;
                    }

                    currentEntity = currentEntity.eat(map);

                    if (currentEntity.hasMoved) {
                        continue;
                    }

                    List<Coordinates> pathToFood = bfs.findShortestPathForEntity(map, currentPos);
                    if (!pathToFood.isEmpty()) {
                        currentEntity.nextMove = pathToFood.get(1);
                        map.moveEntity(currentEntity.coordinates, currentEntity.nextMove);

                    } else {
                        List<Coordinates> availableMoves = currentEntity.getAvailableMoves(map);
                        if (!availableMoves.isEmpty()) {
                            currentEntity.nextMove = availableMoves.getFirst();
                            map.moveEntity(currentEntity.coordinates, currentEntity.nextMove);
                        }
                    }

                }
            }
        }
        for (Creature creature : map.getAllCreatures()) {
            if(creature.hasMoved) {
                creature.setHasMoved(false);
            }
        }
        Thread.sleep(4000);
    }
}
