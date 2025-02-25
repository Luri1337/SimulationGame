package utils;

public class CoordinatesHandler {
    public static void validateCoordinate(Coordinates coordinates, GameBoard map) throws Exception {
        if (coordinates != null){
            if(coordinates.getY() < map.getMAP_HEIGHT() && coordinates.getY() >= 0){
                if(coordinates.getX() < map.getMAP_WIDTH() && coordinates.getX() >= 0){
                    return;
                }
            }
        }
        throw new Exception("Coordinates is out of bounds");
    }

    public static boolean canShift (Coordinates coordinates, Coordinates shift, GameBoard map){
        int newX  = coordinates.getX() + shift.getX();
        int newY  = coordinates.getY() + shift.getY();

        if((newX < 0) || (newX >= map.getMAP_WIDTH())) {
            return false;
        }
        if((newY < 0) || (newY >= map.getMAP_HEIGHT())) {
            return false;
        }

        return true;
    }
}
