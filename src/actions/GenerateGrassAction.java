package actions;

import entities.EntityType;
import utils.BoardUtils;
import utils.GameBoard;

public class GenerateGrassAction implements Action {
    private final BoardUtils boardUtils = new BoardUtils();
    @Override
    public void execute(GameBoard map) throws Exception {
        int difference = map.getInitialGrassCount() - map.getCurrentGrassCount();
        if(difference != 0) {
            boardUtils.createEntity(map, EntityType.GRASS, difference);
        }
        map.setCurrentGrassCount(map.getInitialGrassCount());
    }
}
