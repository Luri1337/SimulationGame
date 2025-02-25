package actions;

import utils.GameBoard;

public interface Action {
    void execute(GameBoard map) throws Exception;
}
