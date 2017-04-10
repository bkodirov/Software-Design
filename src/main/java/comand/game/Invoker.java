package comand.game;

/**
 * Created by Beka on 10.04.17.
 */
public class Invoker {
    private ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void onUserSomethingDidListener() {
        command.doAction();
    }

    public void onUserCanceled() {
        command = command.undo();
    }
}
