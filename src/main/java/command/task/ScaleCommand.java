package command.task;

import java.util.Stack;

/**
 * Created by Beka on 10.04.17.
 */
public class ScaleCommand extends ICommand {

    private final int scaleFactor;

    public ScaleCommand(GameBoard gameBoard, Stack<ICommand> commandStack, int scaleFactor) {
        super(gameBoard, commandStack);
        this.scaleFactor = scaleFactor;
    }

    @Override
    protected void onDoAction() {
        gameBoard.scale(scaleFactor);
    }

    @Override
    protected void onUndo() {
        gameBoard.scale(1/scaleFactor);
    }
}
