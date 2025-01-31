package Utils;

import Entities.Creature;
import Entities.Herbivore;
import Entities.Predator;

import java.util.List;

public class Actions {

    public static void turnAction(GameMap map, BFS bfs) {
        for (int y = 10; y >= 1; y--) {
            for (int x = 1; x <= 10; x++) {
                if (map.getMap().get(new Coordinates(x, y)) instanceof Herbivore
                        || map.getMap().get(new Coordinates(x, y)) instanceof Predator) {

                    Coordinates currentPos = new Coordinates(x, y);
                    Creature currentEntity = (Creature) map.getEntity(currentPos);

                    currentEntity = currentEntity.eat(map);

                    if (currentEntity.hasMoved) {
                        continue;
                    }

                    List<Coordinates> pathToFood = bfs.findShortestPathForEntity(map, currentPos);
                    if (!pathToFood.isEmpty()) {
                        currentEntity.nextMove = pathToFood.get(1);
                    } else {
                        List<Coordinates> availableMoves = currentEntity.getAvailableMoves(map);
                        if (!availableMoves.isEmpty()) {
                            currentEntity.nextMove = availableMoves.get(0);
                        }
                    }

                }
            }
        }
        for (Creature creature : map.getAllCreatures()) {
            if(creature.hasMoved) {
                creature.setHasMoved(false);
               continue;
            }
            map.moveEntity(creature.coordinates, creature.nextMove);
            creature.setHasMoved(false);
        }
    }
}
