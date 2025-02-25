package utils;

import entities.Entity;

public class BoardConsoleRenderer {
    private final BoardUtils boardUtils = new BoardUtils();
    private static final String GREEN = "\033[42m";
    private static final String WHITE = "\033[47m";
    private static final String RESET = "\033[0m";

    public void render(GameBoard map) throws Exception {
        for (int y = map.getMAP_HEIGHT() - 1; y >= 0 ; y--) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < map.getMAP_WIDTH(); x++) {
                if(map.isSquareEmpty(new Coordinates(x, y))){
                    line.append(getSpriteForEmptySquare(new Coordinates(x, y), map));
                }else{
                    line.append(getPieceSprite(map.getEntity(new Coordinates(x, y)), map));
                }

            }
            line.append(RESET);
            System.out.println(line);
        }
    }

    private String getPieceSprite(Entity entity, GameBoard map ) throws Exception {
        return switch (entity.getClass().getSimpleName()){
            case "Predator" -> colorizeSprite(" \uD83D\uDC3A ", boardUtils.isSquareDark(map.getCoordinates(entity), map));
            case "Herbivore" -> colorizeSprite(" \uD83D\uDC07 ", boardUtils.isSquareDark(map.getCoordinates(entity), map));
            case "Tree" -> colorizeSprite(" \uD83C\uDF34 ",boardUtils.isSquareDark(map.getCoordinates(entity), map));
            case "Rock" -> colorizeSprite(" \uD83E\uDEA8 ", boardUtils.isSquareDark(map.getCoordinates(entity), map));
            case "Grass" -> colorizeSprite(" \uD83C\uDF31 ", boardUtils.isSquareDark(map.getCoordinates(entity), map));
            default -> throw new IllegalStateException("Unexpected value: " + entity.getClass().getSimpleName());
        };
    }

    public String colorizeSprite(String sprite, boolean isSquareDark){
        String result = sprite;

       if (isSquareDark){
           result = GREEN + result;
       }else{
           result = WHITE + result;
       }

       return result;

    }

    private String getSpriteForEmptySquare(Coordinates coordinates, GameBoard map) throws Exception {
        return colorizeSprite("    ", boardUtils.isSquareDark(coordinates, map));
    }

}
