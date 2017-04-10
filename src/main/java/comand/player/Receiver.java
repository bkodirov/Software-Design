package comand.player;

/**
 * Created by Beka on 10.04.17.
 * This is a class which works with system system Media Player, It could be Proxy...
 */
public class Receiver {
    public void play() {
        System.out.println("Music player status is playing");
    }

    public void pause() {
        System.out.println("Music player status is pause");
    }

    public void stop() {
        System.out.println("Music player status is stop");
    }

    public void next() {
        System.out.println("Music player status is next");
    }

    public void previous() {
        System.out.println("Music player status is previous");
    }

    public boolean isPlaying() {
        return true;
    }
}
