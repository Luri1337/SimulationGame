package actions;

import entities.Creature;
import entities.Entity;
import utils.GameBoard;

public class ResetMovementAction implements Action {
    @Override
    public void execute(GameBoard map) {
        for (Entity entity : map.getAllEntities()) {
            if(entity instanceof Creature creature) {
                if(creature.isHasMoved()) {
                    creature.setHasMoved(false);
                }
            }
        }
    }
}
