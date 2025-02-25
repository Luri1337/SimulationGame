package actions;

import entities.Creature;
import entities.Entity;
import utils.BFS;
import utils.Coordinates;
import utils.GameBoard;

import java.util.List;

public class MoveAction implements Action {
    private final BFS bfs = new BFS();

    @Override
    public void execute(GameBoard map) throws Exception {
        List<Entity> entities = map.getAllEntities();
        for (Entity entity : entities) {
            if (entity instanceof Creature creature && map.contains(entity)) {
                creature.eat(map);

                if (creature.isHasMoved()) {continue;}
                else {
                    List<Coordinates> pathToFood = bfs.findShortestPath(map, creature.getCoordinates(), creature.getTargetType());
                    if (!pathToFood.isEmpty() && pathToFood.size() > 2) {
                        creature.setNextMove(pathToFood.get(1));
                        creature.move(creature.getCoordinates(), creature.getNextMove(), map);

                    }
                    else {
                        List<Coordinates> availableMoves = creature.getAvailableMoves(map);
                        if (!availableMoves.isEmpty()) {
                            creature.setNextMove(availableMoves.getFirst());
                            creature.move(creature.getCoordinates(), creature.getNextMove(), map);
                        }
                    }
                }
            }
        }
    }
}
