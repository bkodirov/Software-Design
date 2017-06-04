package command.media_player;

/**
 * Created by Beka on 10.04.17.
 */
public class NextCommand extends ICommand {
    public NextCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void doAction() {
        receiver.next();
    }
}
