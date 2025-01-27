package Utils;

import Entities.Entity;

import java.awt.*;

public class MapConsoleRenderer {
    public static final String GREEN = "\033[42m";
    public static final String WHITE = "\033[47m";
    public static final String RESET = "\033[0m";

    public void render(GameMap map){
        for (int y = 10; y >= 1 ; y--) {
            String line = "";
            for (int x = 1; x <= 10; x++) {
                if(map.isSquareEmpty(new Coordinates(x, y))){
                    line += getSpriteForEmptySquare(new Coordinates(x, y));
                }else{
                    line += getPieceSprite(map.getEntity(new Coordinates(x, y)));
                }

            }
            line += RESET;
            System.out.println(line);
        }
    }

    private String getPieceSprite(Entity entity) {
        return switch (entity.getClass().getSimpleName()){
            case "Predator" -> colorizeSprite(" \uD83D\uDC3A ", Color.MAGENTA, GameMap.isSquareDark(entity.coordinates));
            case "Herbivore" -> colorizeSprite(" \uD83D\uDC07 ", Color.MAGENTA, GameMap.isSquareDark(entity.coordinates));
            case "Tree" -> colorizeSprite(" \uD83C\uDF32 ", Color.MAGENTA, GameMap.isSquareDark(entity.coordinates));
            case "Rock" -> colorizeSprite(" \uD83E\uDEA8 ", Color.MAGENTA, GameMap.isSquareDark(entity.coordinates));
            case "Grass" -> colorizeSprite(" \uD83C\uDF31 ", Color.MAGENTA, GameMap.isSquareDark(entity.coordinates));
            default -> throw new IllegalStateException("Unexpected value: " + entity.getClass().getSimpleName());
        };




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
