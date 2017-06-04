package command.media_player;

/**
 * Created by Beka on 10.04.17.
 */
public class PreviousCommand extends ICommand {
    public PreviousCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void doAction() {
        receiver.previous();
    }
}
