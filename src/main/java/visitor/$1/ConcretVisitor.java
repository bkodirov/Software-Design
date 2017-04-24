package visitor.$1;

/**
 * Created by Beka on 23.04.17.
 */
public class ConcretVisitor implements Visitor {
    @Override
    public int visit(ConcretVisitable1 visitable) {
        return 0;
    }

    @Override
    public int visit(ConcretVisitable2 visitable) {
        return 0;
    }

    @Override
    public int visit(ConcretVisitable3 visitable) {
        return 0;
    }
}
