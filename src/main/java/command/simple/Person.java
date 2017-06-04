package command.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beka on 04.06.17.
 */
public class Person {
    private List<Person> children = new ArrayList<>();

    public List<Person> getChildren() {
        return children;
    }
}
