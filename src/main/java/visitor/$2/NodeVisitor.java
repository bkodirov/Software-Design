package visitor.$2;

/**
 * This is a visitor interface
 * Created by Beka on 24.04.17.
 */
public interface NodeVisitor {
    void visit(Node node);

    void visit(Root root);
}
