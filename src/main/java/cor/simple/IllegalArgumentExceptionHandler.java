package cor.simple;

public class IllegalArgumentExceptionHandler extends AbstractHandler {

    @Override
    public boolean canHandle(Throwable t) {
        if (t.getClass() == IllegalArgumentException.class) {
            System.err.println("Caught IllegalArgumentException instance");
            return true;
        } else {
            return false;
        }
    }
}
