package comand.game;

import java.util.Stack;

/**
 * Created by Beka on 10.04.17.
 */
public class Client {
    public static void main(String[] args) {
        Stack<ICommand> stack = new Stack<>();
        GameBoard board = new GameBoard();
        ICommand create = new CreateCommand(board, stack, 5);
        ICommand scale = new ScaleCommand(board, stack, 2);
        ICommand move = new MoveCommand(board, stack, GameBoard.Direction.DOWN, 2);

        Invoker i=new Invoker();
        i.setCommand(create);
        //Simulating doing some action by user side
        i.onUserSomethingDidListener();

        i.setCommand(move);
        //Simulating doing some action by user side
        i.onUserSomethingDidListener();

        i.setCommand(scale);
        //Simulating doing some action by user side
        i.onUserSomethingDidListener();

        //Simulating canceling last action by user side
        i.onUserCanceled();
    }
}
