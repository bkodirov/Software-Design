package command.task;

import java.util.Stack;

/**
 * Created by Beka on 10.04.17.
 */
public class MoveCommand extends ICommand {
    private final GameBoard.Direction direction;
    private final int step;

    public MoveCommand(GameBoard gameBoard, Stack<ICommand> commandStack, GameBoard.Direction direction, int step) {
        super(gameBoard, commandStack);
        this.direction = direction;
        this.step = step;
    }

    @Override
    protected void onDoAction() {
        gameBoard.move(direction, step);
    }

    @Override
    protected void onUndo() {
        gameBoard.move(GameBoard.Direction.getOpposite(direction), step);
    }
}
