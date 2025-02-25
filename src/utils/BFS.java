package utils;

import entities.*;

import java.util.*;

public class BFS {
    public List<Coordinates> findShortestPath(GameBoard map, Coordinates start, EntityType target) {
        Queue<PathNode> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();

        queue.add(new PathNode(start, List.of(start)));
        visited.add(start);

        while (!queue.isEmpty()) {
            PathNode current = queue.poll();
            Coordinates currentPosition = current.position;

            try {
                if (map.getEntity(currentPosition).getEntityType() == target) {
                    return current.path;
                }
            } catch (Exception e) {}

            for (Coordinates neighbor : getAvailableMoves(map, currentPosition, target)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    List<Coordinates> newPath = new ArrayList<>(current.path);
                    newPath.add(neighbor);
                    queue.add(new PathNode(neighbor, newPath));
                }
            }
        }
        return Collections.emptyList();
    }

    private List<Coordinates> getAvailableMoves(GameBoard map, Coordinates position, EntityType target) {
        List<Coordinates> moves = new ArrayList<>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] dir : directions) {
            int x = position.getX() + dir[0];
            int y = position.getY() + dir[1];
            Coordinates next = new Coordinates(x, y);

            boolean isEmpty;
            boolean isTarget = false;

            try {
                isEmpty = map.isSquareEmpty(next);
            } catch (Exception ignored) {
                continue;
            }

            try {
                isTarget = map.getEntity(next).getEntityType() == target;
            } catch (Exception ignored) {}

            if (isEmpty || isTarget) {
                moves.add(next);
            }
        }
        return moves;
    }




}

