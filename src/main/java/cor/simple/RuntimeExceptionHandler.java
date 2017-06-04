package cor.simple;

/**
 * Concrete AbstractHandler classes
 */
public class RuntimeExceptionHandler extends AbstractHandler {

    @Override
    public boolean canHandle(Throwable t) {
        if (t.getClass() == RuntimeException.class) {
            System.err.println("Caught RuntimeException instance");
            return true;
        } else {
            return false;
        }
    }
}