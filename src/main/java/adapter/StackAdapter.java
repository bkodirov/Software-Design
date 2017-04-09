package adapter;

import java.util.Stack;

/**
 * Created by Beka on 09.04.17.
 */
public class StackAdapter extends Adapter {
    //This is an our Adaptee!!!
    private final Stack<String> stack;

    public StackAdapter(Stack<String> stack) {
        this.stack = stack;
    }

    public void push(String str) {
        stack.push(str);
    }

    public String pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
