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
public class LazyThreadSafeSingleton {
    private static LazyThreadSafeSingleton INSTANCE;

    /**
     * The Singleton Constructor. Note that it is private! No client
     * can instantiate a Singleton object directly!
     */
    private LazyThreadSafeSingleton() {
    }

    /**
     * Returns a reference to the single instance. Creates the instance if it
     * does not yet exist. (This is called lazy instantiation). This is thread safe. This implementation works fine
     * and provides thread-safety but it reduces the performance because of cost associated with the synchronized method.
     * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html">Java synchronized</a>
     */
    public static synchronized LazyThreadSafeSingleton getInstance() {
        if (INSTANCE == null)
            INSTANCE = new LazyThreadSafeSingleton();
        return INSTANCE;
    }
}
