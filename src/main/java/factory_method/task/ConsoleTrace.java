package factory_method.task;

/**
 * Created by Beka on 10.04.17.
 */
public class ConsoleTrace implements Trace{
    private volatile boolean isDebuggable;
    @Override
    public void setDebug(boolean debug) {
        this.isDebuggable = debug;
    }

    @Override
    public void debug(String message) {
        System.out.println(message);
    }

    @Override
    public void error(String message) {
        System.err.println(message);
    }
}
