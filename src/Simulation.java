import Entities.Entity;
import Entities.Herbivore;
import Entities.Predator;
import Utils.*;

import javax.swing.*;
import java.util.List;
import java.util.Set;
import java.util.Timer;

public class Simulation {
    private final BFS bfs = new BFS();
    private final GameMap map;
    MapConsoleRenderer renderer = new MapConsoleRenderer();
    private int movesCounter;
    private Actions action;

    public Simulation(GameMap map) {
        this.map = map;
    }
    public void start() throws InterruptedException {
        simulationLoop();
    }

    public void simulationLoop() throws InterruptedException {
        map.setupEntitiesStartPositions();
        while(true){
            System.out.println();
            renderer.render(map);
            Actions.turnAction(map, bfs);
            Thread.sleep(4000);
        }
    }
    public void finish(){}

    public GameMap getMap() {
        return map;
    }
}
