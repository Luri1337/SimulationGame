import utils.*;

import java.util.Scanner;


public class Simulation {
    private final BFS bfs = new BFS();
    private final GameMap map;
    MapConsoleRenderer renderer = new MapConsoleRenderer();
    boolean isPaused = false;

    public Simulation(GameMap map) {
        this.map = map;
    }
    public void start() throws InterruptedException {
        map.setupEntitiesStartPositions();
        simulationLoop();
    }

    public void simulationLoop() throws InterruptedException {
        new Thread(this::pauseSimulation).start();
        while(true){
            if (isPaused) {
                System.out.println("Пауза... Нажмите ENTER, чтобы продолжить.");
                while (isPaused) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println();
            renderer.render(map);
            Actions.turnAction(map, bfs);
            if (map.getMap().isEmpty()){
                System.out.println("Game Over");
                return;
            }
        }
    }

    public void pauseSimulation(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (scanner.nextLine().equals("")){
                isPaused = !isPaused;
            }
        }
    }

    public GameMap getMap() {
        return map;
    }
}
