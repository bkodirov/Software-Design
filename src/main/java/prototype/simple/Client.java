package prototype.simple;

/**
 * Created by Beka on 09.05.17.
 * Client
 */
public class Client {

    public static void main(String[] args) {
        Person person1 = new Person("Fred");
        System.out.println("person 1:" + person1);
        Person person2 = person1.doClone();
        System.out.println("person 2:" + person2);
    }
}
