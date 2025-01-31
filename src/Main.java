import Entities.Entity;
import Entities.Predator;
import Utils.BFS;
import Utils.Coordinates;
import Utils.GameMap;
import Utils.MapConsoleRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameMap map = new GameMap();


        Simulation simulation = new Simulation(map);
        simulation.start();

        int a = 123;
    }
}
