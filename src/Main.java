import Utils.GameMap;
import Utils.MapConsoleRenderer;

public class Main {
    public static void main(String[] args) {
        MapConsoleRenderer renderer = new MapConsoleRenderer();
        renderer.render(new GameMap());
    }
}
