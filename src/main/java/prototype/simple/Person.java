package prototype.simple;

/**
 * Prototype concreate class
 */
public class Person implements Prototype<Person> {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public Person doClone() {
        return new Person(name);
    }

    public String toString() {
        return "This person is named " + name;
    }
}
