package cor.simple;

/**
 * Created by Beka on 03.06.17.
 */
public class ThrowableHandler extends AbstractHandler {

    @Override
    public boolean canHandle(Throwable t) {
        if (t.getClass() == Throwable.class) {
            System.err.println("Caught Throwable instance");
            return true;
        } else {
            return false;
        }
    }
}
