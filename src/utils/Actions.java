package utils;

import entities.Creature;
import entities.EmptyCell;

import java.util.List;

public class Actions {

    public static void turnAction(GameMap map, BFS bfs) throws InterruptedException {
        List<Creature> creatures = map.getAllCreatures();
        for (Creature creature : creatures) {
            if(map.getEntity(creature.coordinates) instanceof EmptyCell) {
                continue;
            }

            if (creature.hasMoved) continue;

            if (!tryToEat(creature, map)) {
                moveCreature(creature, map, bfs);
            }
        }

        resetMovement(map);

        Thread.sleep(4000);
    }

    private static boolean tryToEat(Creature creature, GameMap map) {
        creature = creature.eat(map);
        return creature.hasMoved;
    }

    public static void moveCreature(Creature creature, GameMap map, BFS bfs) {
        List<Coordinates> pathToFood = bfs.findShortestPathForEntity(map, creature.coordinates);
        if (!pathToFood.isEmpty()) {
            creature.nextMove = pathToFood.get(1);
            map.moveEntity(creature.coordinates, creature.nextMove);

        } else {
            List<Coordinates> availableMoves = creature.getAvailableMoves(map);
            if (!availableMoves.isEmpty()) {
                creature.nextMove = availableMoves.getFirst();
                map.moveEntity(creature.coordinates, creature.nextMove);
            }
        }
    }

    private static void resetMovement(GameMap map){
        for (Creature creature : map.getAllCreatures()) {
            if(creature.hasMoved) {
                creature.setHasMoved(false);
            }
        }
    }
}
