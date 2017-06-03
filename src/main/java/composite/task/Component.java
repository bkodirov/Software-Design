package composite.task;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Component {
    protected Collection<Component> list = new ArrayList<Component>();
    protected String title;

    public Component(String title) {
        this.title = title;
    }

    public abstract void render();

    public void addChild(Component item) {
        list.add(item);
    }
}