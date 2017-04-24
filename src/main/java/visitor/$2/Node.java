package visitor.$2;

/**
 * Created by Beka on 24.04.17.
 */
public class Node extends Composite {

    public Node(String title, Side side) {
        super(title, side);
    }

    @Override
    public int accept(NodeVisitor visitor) {
        int counter = 1;
        for (Composite composite : compositeList) {
            counter += composite.accept(visitor);
        }
        return counter;
    }
}
