package adapter;

import java.util.Queue;

/**
 * Created by Beka on 09.04.17.
 */
public class QueueAdapter extends Adapter{

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
