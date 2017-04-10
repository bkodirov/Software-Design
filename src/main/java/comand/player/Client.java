package comand.player;

/**
 * Created by Beka on 10.04.17.
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        ICommand play = new PlayCommand(receiver);
        ICommand stop = new StopCommand(receiver);
        ICommand pause = new PauseCommand(receiver);
        ICommand next = new NextCommand(receiver);
        ICommand prev = new PreviousCommand(receiver);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setNextCommand(next);
        remoteControl.setPreviousCommand(prev);
        if (receiver.isPlaying()) {
            remoteControl.setPlayPauseButtonCommand(pause);
        } else {
            remoteControl.setPlayPauseButtonCommand(play);
        }
    }
}
