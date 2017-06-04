package cor.simple;

/**
 * AbstractHandler abstract class (AbstractHandler)
 */
public abstract class AbstractHandler {
    protected AbstractHandler nextAgent;

    abstract public boolean canHandle(Throwable t);

    boolean handle(Throwable t) {
        if (canHandle(t)) {
            return true;
        } else {
            if (nextAgent != null) {
                return nextAgent.handle(t);
            } else {
                System.err.println("Unknown Throwable instance caught");
                return false;
            }
        }
    }
}