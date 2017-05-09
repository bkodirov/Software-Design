package adapter.simple;

/**
 * Target interface
 */
public interface Target {
    void push(String str);

    String pop();

    boolean isEmpty();
}
