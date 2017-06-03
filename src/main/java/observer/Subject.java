package observer;

/**
 * Created by Beka on 27.04.17.
 */
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
