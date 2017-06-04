package command.media_player;

/**
 * Created by Beka on 10.04.17.
 */
public class PauseCommand extends ICommand {
    public PauseCommand(Receiver receiver) {
        super(receiver);
    }
    @Override
    public void doAction() {
        receiver.pause();
    }
}
