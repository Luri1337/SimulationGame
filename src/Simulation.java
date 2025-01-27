import Entities.Entity;
import Entities.Herbivore;
import Entities.Predator;
import Utils.*;

import java.util.Set;
import java.util.Timer;

public class Simulation {
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
            for (int y = 10; y >= 1 ; y--) {
                for (int x = 1; x <= 10; x++) {
                    if (map.getEntity(new Coordinates(x, y)) != null){
                        if(map.getEntity(new Coordinates(x, y)).getClass() == Herbivore.class ||
                                map.getEntity(new Coordinates(x, y)).getClass() == Predator.class
                        ){
                            Entity entity = map.getEntity(new Coordinates(x, y));
                            Set<Coordinates> entityAvailableMoves = entity.getAvailableMoves(map);
                            if(entityAvailableMoves.isEmpty()){
                                continue;
                            }
                            map.moveEntity(new Coordinates(x,y), (Coordinates) entityAvailableMoves.toArray()[0]);
                        }
                    }
                }
            }
            Thread.sleep(4000);
        }
    }
    public void finish(){}

    public GameMap getMap() {
        return map;
    }
}
