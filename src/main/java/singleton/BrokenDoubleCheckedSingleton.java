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
public class BrokenDoubleCheckedSingleton {
    private static BrokenDoubleCheckedSingleton INSTANCE;

    /**
     * The Singleton Constructor. Note that it is private! No client
     * can instantiate a Singleton object directly!
     */
    private BrokenDoubleCheckedSingleton() {
    }

    /**
     * This is traditional Double Checked Locking Singleton. This is broken. Java implementation of classical DCL
     * doesn't work. Java Memory Model(JSR-133) allows returning null here. It is a little bit hard to understand why
     * it can return null. In order to dive deeper read about
     * @see <a href="https://shipilev.net/blog/2014/safe-public-construction/">Safe Publishing</a>
     *
     * You can avoid returning null using local varaibale. Threads cann't concur for local varaible. But in this
     * approach you will face to Data Racing between thread. Meanwhile Java community decided considering DCL with
     * local variable as a more proper one. But it is not still safe becase of Data Racing between thread.
     * Remember creating object is not atomic operation in Java!!!
     * @return
     */
    public static BrokenDoubleCheckedSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (BrokenDoubleCheckedSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BrokenDoubleCheckedSingleton();
                }
            }
        }
        //Here you can get NULL when you have huge concurring threads
        return INSTANCE;
    }
}