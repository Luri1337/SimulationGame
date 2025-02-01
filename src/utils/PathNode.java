package utils;

import java.util.List;

public class PathNode {
    Coordinates position;
    List<Coordinates> path;

    public PathNode(Coordinates position, List<Coordinates> path) {
        this.position = position;
        this.path = path;
    }
}
