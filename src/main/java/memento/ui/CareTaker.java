package memento.ui;

import java.util.Stack;

/**
 * Created by Beka on 11.04.17.
 * CareTaker class (keeps a collection of previous states in
 * case client needs to restore them or undo something)
 */
public class CareTaker {
    private Stack<Controller.Memento> stateStack = new Stack<>();

    public void add(Controller.Memento memento) {
        stateStack.push(memento);
    }

    public Controller.Memento pop() {
        if (!stateStack.isEmpty()) {
            return stateStack.pop();
        }
        return null;
    }

    public Controller.Memento get() {
        if (!stateStack.isEmpty()) {
        return stateStack.peek();
        }
        return null;
    }
}
