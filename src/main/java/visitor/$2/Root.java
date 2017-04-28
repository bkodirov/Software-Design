package visitor.$2;

/**
 * Created by Beka on 24.04.17.
 */
public class Root extends Composite {
    public Root() {
        super("Topic", Side.NONE);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}
