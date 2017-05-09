package adapter.simple;

/**
 * Adapter
 */
public class Adapter implements Target {
    private Adaptee adaptee;

    @Override
    public void push(String str) {
        adaptee.add(str);
    }

    @Override
    public String pop() {
        int end = adaptee.getEnd();
        String str = adaptee.get(end);
        adaptee.remove(end);
        return str;
    }

    @Override
    public boolean isEmpty() {
        return adaptee.empty();
    }
}