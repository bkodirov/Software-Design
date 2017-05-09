package adapter.task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Beka
 * Created by Beka on 09.04.17.
 *
 * Collaborates with objects conforming to the Target
 * interface.
 */
public class Client {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<String>();
        Target stackBasedTarget = new StackAdapter(stack);
        stackBasedTarget.push("First element");
        System.out.println(stackBasedTarget.isEmpty());

        Queue<String > queue=new LinkedList<String>();
        Target queueBasedTarget = new QueueAdapter(queue);
        queueBasedTarget.push("First element");
        queueBasedTarget.pop();
        System.out.println(queueBasedTarget.isEmpty());
    }
}
