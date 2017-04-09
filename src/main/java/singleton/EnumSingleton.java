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
public enum EnumSingleton {
    /**
     * To overcome this situation with Reflection, Joshua Bloch suggests the use of Enum to implement Singleton design
     * pattern as Java ensures that any enum value is instantiated only once in a Java program. Since Java Enum values
     * are globally accessible, so is the singleton. The drawback is that the enum type is somewhat inflexible; for
     * example, it does not allow lazy initialization.
     * This approach guarantees the singleton-ness of the object and provides serializability for you in such a way that you
     * always get the same instance
     */
    INSTANCE
}