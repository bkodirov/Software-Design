package visitor.$2;

/**
 * Created by Beka on 24.04.17.
 */
public interface Component {
    void accept(NodeVisitor visitor);
    Side getSide();
    String getName();
}
