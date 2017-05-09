package factory_method.task;

public interface Trace {
    // turn on and off debugging
    void setDebug(boolean debug); // write out a debug message

    void debug(String message); // write out an error message

    void error(String message);
}
