package proxy.simple;

/**
 * Proxy class that implements the subject interface
 */
public class CommandExecutorProtectionProxy implements ICommandExecutor {
    private boolean isAdmin;
    private ICommandExecutor executor;

    public CommandExecutorProtectionProxy(String user, String pwd) {
        if ("username".equals(user) && "password".equals(pwd))
            isAdmin = true;
        executor = new CommandExecutor();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if (isAdmin) {
            executor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("del")) {
                throw new Exception("'delete' command is not allowed for non - admin users. ");
            } else {
                executor.runCommand(cmd);
            }
        }
    }
}