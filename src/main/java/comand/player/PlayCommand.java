package comand.player;

/**
 * Created by Beka on 10.04.17.
 */
public class PlayCommand extends ICommand {
    public PlayCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void doAction() {
        receiver.play();
    }
}
