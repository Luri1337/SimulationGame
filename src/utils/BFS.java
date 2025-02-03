package utils;

import entities.Entity;
import entities.Grass;
import entities.Herbivore;
import entities.Predator;

import java.util.*;

public class BFS {
    public List<Coordinates> findShortestPathForEntity(GameMap map, Coordinates start) {
        Queue<PathNode> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();

        queue.add(new PathNode(start, new ArrayList<>()));

        Entity startEntity = map.getEntity(start);

        while (!queue.isEmpty()) {
            PathNode current = queue.poll();
            Coordinates currentPosition = current.position;
            Entity entity = map.getEntity(currentPosition);

            if (isTarget(startEntity, entity)) {
                current.path.add(currentPosition);
                return current.path;
            }

            visited.add(currentPosition);

            for(Coordinates neighbor : entity.getAvailableMoves(map)){
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);

                    List<Coordinates> newPath = new ArrayList<>(current.path);
                    newPath.add(currentPosition);

                    queue.add(new PathNode(neighbor, newPath));
                }
            }
        }
        return Collections.emptyList();
    }

    private boolean isTarget(Entity startEntity, Entity targetEntity) {
        if (startEntity instanceof Predator && targetEntity instanceof Herbivore) {
            return true;
        }

        if (startEntity instanceof Herbivore && targetEntity instanceof Grass) {
            return true;
        }
        return false;
    }

}

