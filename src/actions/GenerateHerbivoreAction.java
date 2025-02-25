package actions;

import entities.EntityType;
import utils.BoardUtils;
import utils.GameBoard;

public class GenerateHerbivoreAction implements Action {
    private final BoardUtils boardUtils = new BoardUtils();
    @Override
    public void execute(GameBoard map) throws Exception {
        int difference = map.getInitialHerbivoreCount() - map.getCurrentHerbivoreCount();

        if(difference != 0) {
            boardUtils.createEntity(map, EntityType.HERBIVORE, difference);
        }
        map.setCurrentHerbivoreCount(map.getInitialHerbivoreCount());
    }
}
