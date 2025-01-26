import Utils.Actions;
import Utils.GameMap;

public class Simulation {
    private GameMap map = new GameMap();
    private int movesCounter;
    private Actions action;

    public void start(){

    }
    public void finish(){}

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }
}
