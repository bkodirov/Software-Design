package singleton;

/**
 * Created by Beka on 09.04.17.
 * Intent
 * Ensure a class only has one instance, and provide a global point of access to it
 * <p>
 * Motivation
 * Sometimes we want just a single instance of a class to exist in the system
 * For example, we want just one factory for a family of products
 * We need to have that one instance easily accessible
 * And we want to ensure that additional instances of the class cannot be created
 * <p>
 * Structure
 *
 * @see <a href="http://www.eli.sdsu.edu/courses/spring98/cs635/notes/singleton/singleton.gif">Structure of singleton.Singleton</a>
 * <p>
 * Consequences
 * Benefits:
 * Controlled access to sole instance.
 * Controlled number of instances of a certain class.
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    /**
     * The Singleton Constructor. Note that it is private! No client
     * can instantiate a Singleton object directly!
     */
    private Singleton() {
    }

    /**
     * This is traditional Singleton. Thread safe, because  INSTANCE will be created by class loader
     *
     * @return
     */
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
