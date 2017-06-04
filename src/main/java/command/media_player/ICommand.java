package command.media_player;

/**
 * Created by Beka on 10.04.17.
 */
public abstract class ICommand {
    protected Receiver receiver;

    public ICommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void doAction();
}
