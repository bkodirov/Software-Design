package proxy.simple;

import java.io.IOException;

/**
 * Real subject class
 */
class CommandExecutor implements ICommandExecutor {
    @Override
    public void runCommand(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
        System.out.println("'" + cmd + "' command executed.");
    }
}
