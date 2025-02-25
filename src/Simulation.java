import actions.*;
import utils.*;

import java.util.Objects;
import java.util.Scanner;


public class Simulation {
    private final Scanner scanner = new Scanner(System.in);
    private final GameBoard map;
    private final BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    private final BoardUtils boardUtils = new BoardUtils();

    private final Action move = new MoveAction();
    private final Action reset = new ResetMovementAction();
    private final Action generateGrass = new GenerateGrassAction();
    private final Action generateHerbivore = new GenerateHerbivoreAction();

    boolean isPaused = false;

    public Simulation(GameBoard map) {
        this.map = map;
    }

    public void start() throws Exception {
        while (true) {
            printStartPanel();
            String answer = scanner.nextLine();
            if(Objects.equals(answer, "S") || Objects.equals(answer, "s")){
                boardUtils.setupEntitiesStartPositions(map);
                simulationLoop();
            }
            else if(Objects.equals(answer, "E") || Objects.equals(answer, "e")){
                System.exit(0);
            }
            else{
                System.out.println("INVALID INPUT");
            }
        }
    }

    private void simulationLoop() throws Exception {
        new Thread(this::pauseSimulation).start();
        while(true){
            checkPause();
            System.out.println();
            renderer.render(map);
            move.execute(map);
            reset.execute(map);
            generateGrass.execute(map);
            generateHerbivore.execute(map);
            Thread.sleep(2000);
        }
    }

    private void pauseSimulation(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (scanner.nextLine().isEmpty()){
                isPaused = !isPaused;
            }
        }
    }

    private void checkPause(){
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
    }

    private void printStartPanel(){
        System.out.println("""
                IF YOU WANT START SIMULATION ENTER S
                IF YOU WANT EXIT FROM SIMULATION ENTER E
                
                !!! YOU CAN PAUSE SIMULATION IF YOU WILL PRESS ENTER 
                """);
    }
}
