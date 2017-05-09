package adapter.task;

import java.util.Queue;

/**
 * Created by Beka on 09.04.17.
 * Intent
 * Convert the interface of a class into another interface clients expect. Adapter lets classes work together that
 * couldn't otherwise because of incompatible interfaces.
 * <p>
 * Motivation
 * a) Sometimes a toolkit or class library cannot be used because its interface is incompatible with the interface
 * required by an application
 * b) We cannot change the library interface
 * c) Even if we did have the source code, we should not change the library
 * <p>
 * Structure
 * - An adapter relies on object composition
 *
 * @see <a href="https://lostechies.com/johnteague/files/2011/03/image_5157213E.png">UML like structure of Adapter pattern</a>
 * <p>
 * Participants
 * Target
 * - Defines the domain-specific interface that Client uses. Adaptee
 * - Defines an existing interface that needs adapting. Adapter
 * - Adapts the interface of Adaptee to the Target interface. Client
 * - Collaborates with objects conforming to the Target interface.
 * <p>
 * Applicability
 * Use the Adapter pattern when:
 * You want to use an existing class that performs similar functions but with a different interface. For example, a
 * third-party report generator based on xml input.
 */
public class QueueAdapter implements Target{

    //This is an our Adaptee!!!
    private final Queue<String>  queue;

    public QueueAdapter(Queue<String> queue) {
        this.queue = queue;
    }

    public void push(String str) {
        queue.offer(str);
    }

    public String pop() {
        return queue.remove();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
