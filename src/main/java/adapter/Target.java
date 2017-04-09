package adapter;

/**
 * Created by Beka on 09.04.17.
 * Defines the domain-specific interface that Client uses.
 */
public interface Target {
    void push(String str);

    String pop();

    boolean isEmpty();
}
