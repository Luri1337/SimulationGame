import utils.GameBoard;

public class Main {
    public static void main(String[] args) throws Exception {
        GameBoard map = new GameBoard(10, 10, 3, 3);

        Simulation simulation = new Simulation(map);
        simulation.start();
    }
}
