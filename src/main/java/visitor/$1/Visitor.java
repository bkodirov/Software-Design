package visitor.$1;

/**
 * Created by Beka on 23.04.17.
 */
public interface Visitor {
    int visit(ConcretVisitable1 visitable);

    int visit(ConcretVisitable2 visitable);

    int visit(ConcretVisitable3 visitable);
}
