package visitor.$1;

/**
 * Created by Beka on 23.04.17.
 */
public class ConcretVisitable2 implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
