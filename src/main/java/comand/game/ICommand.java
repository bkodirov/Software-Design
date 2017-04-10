package comand.game;

import java.util.Stack;

/**
 * Created by Beka on 10.04.17.
 */
public abstract class ICommand {
    protected GameBoard gameBoard;
    private Stack<ICommand> commandStack;

    public ICommand(GameBoard gameBoard, Stack<ICommand> commandStack) {
        this.gameBoard = gameBoard;
        this.commandStack = commandStack;
    }

    public void doAction() {
        onDoAction();
        commandStack.push(this);
    }

    public ICommand undo() {
        onUndo();
        return commandStack.pop();
    }

    protected abstract void onDoAction();

    protected abstract void onUndo();
}
