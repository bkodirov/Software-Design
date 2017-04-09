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
public class BillPughSingleton {

    /**
     * The Singleton Constructor. Note that it is private! No client
     * can instantiate a Singleton object directly!
     */
    private BillPughSingleton() {
    }

    /**
     * Notice the private inner static class that contains the instance of the singleton class. When the singleton class
     * is loaded, SingletonHelper class is not loaded into memory and only when someone calls the getInstance method,
     * this class gets loaded and creates the Singleton class instance.
     * This is the most widely used approach for Singleton class as it doesn’t require synchronization. This also called
     * Singleton holder pattern
     */
    public static synchronized BillPughSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/innerclasses.html">Java Inner classes</a>
     */
    private static class SingletonHolder{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
}
