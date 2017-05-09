package proxy.simple;

/**
 * Subject interface
 */
public interface ICommandExecutor {
    void runCommand(String cmd) throws Exception;
}