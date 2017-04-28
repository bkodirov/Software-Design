package visitor.$2;

/**
 * Created by Beka on 24.04.17.
 */
public class Node extends Composite {

    public Node(String title, Side side) {
        super(title, side);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}
