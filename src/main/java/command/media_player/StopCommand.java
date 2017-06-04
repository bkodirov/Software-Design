package command.media_player;

/**
 * Created by Beka on 10.04.17.
 */
public class StopCommand extends ICommand {
    public StopCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void doAction() {
        receiver.stop();
    }
}
