package Utils;

import Entities.Grass;
import Entities.Herbivore;

import java.util.*;

public class BFS {
    public List<Coordinates> findShortestPathForEntity(GameMap map, Coordinates start) {
        Queue<PathNode> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();

        queue.add(new PathNode(start, new ArrayList<>()));

        while (!queue.isEmpty()) {
            PathNode current = queue.poll();
            Coordinates currentPosition = current.position;

            if(map.getEntity(currentPosition) != null) {
                switch (map.getEntity(start).getClass().getSimpleName()){
                    case "Predator"-> {
                        if(map.getEntity(currentPosition).getClass() == Herbivore.class) {
                            current.path.add(currentPosition);
                            return current.path;
                        }
                    }
                    case "Herbivore" -> {
                        if(map.getEntity(currentPosition).getClass() == Grass.class) {
                            current.path.add(currentPosition);
                            return current.path;
                        }
                    }
                }
            }

            visited.add(currentPosition);

            for(Coordinates neighbor : map.getEntity(currentPosition).getNeighbors(currentPosition)){
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

}

