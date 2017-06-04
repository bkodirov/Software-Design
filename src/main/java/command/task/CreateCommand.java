package command.task;

import java.util.Stack;

/**
 * Created by Beka on 10.04.17.
 */
public class CreateCommand extends ICommand {

    private final int size;

    public CreateCommand(GameBoard gameBoard, Stack<ICommand> commandStack, int size) {
        super(gameBoard, commandStack);
        this.size = size;
    }

    @Override
    protected void onDoAction() {
        gameBoard.create(size);
    }

    @Override
    protected void onUndo() {
        gameBoard.remove(size);
    }
}
