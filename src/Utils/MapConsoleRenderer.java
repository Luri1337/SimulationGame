package Utils;

import Entities.Coordinates;
import Entities.Entity;

import java.awt.*;
import java.util.Map;

public class MapConsoleRenderer {
    public static final String GREEN = "\033[42m";
    public static final String WHITE = "\033[47m";
    public static final String RESET = "\033[0m";

    public void render(GameMap map){
        for (int y = 10; y >= 1 ; y--) {
            String line = "";
            for (int x = 1; x <= 10; x++) {
                line += getSpriteForEmptySquare(new Coordinates(x, y));
            }
            line += RESET;
            System.out.println(line);
        }
    }

    public String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark){
        String result = sprite;

       if (isSquareDark){
           result = GREEN + result;
       }else{
           result = WHITE + result;
       }

       return result;

    }

    private String getSpriteForEmptySquare(Coordinates coordinates){
        return colorizeSprite("    ", Color.YELLOW, GameMap.isSquareDark(coordinates));
    }

}
