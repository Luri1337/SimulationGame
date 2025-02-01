import utils.GameMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameMap map = new GameMap();


        Simulation simulation = new Simulation(map);
        simulation.start();
    }
}
