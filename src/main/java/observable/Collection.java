package observable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beka on 27.04.17.
 */
public class Collection implements Subject {
    private final List<Observer> observerList = new ArrayList<>();
    private final List<String> nameList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    public void add(String name) {
        nameList.add(name);
        notifyObservers();
    }

    public void remove(String name) {
        nameList.remove(name);
        notifyObservers();
    }

    public int size() {
        return nameList.size();
    }

    public List<String> getNames() {
        return new ArrayList<>(nameList);
    }
}
