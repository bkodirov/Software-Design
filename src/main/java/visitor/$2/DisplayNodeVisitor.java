package visitor.$2;

/**
 * Created by Beka on 24.04.17.
 */
public class DisplayNodeVisitor implements NodeVisitor {
    @Override
    public void visit(Node node) {
        int totalChildCount = 1;
        for (Composite composite : node.getChilds()) {
            totalChildCount++;
            totalChildCount += composite.getChilds().size();
        }
        System.out.println(String.format("%d %s nodes",  totalChildCount, node.getName().charAt(0)));
    }

    @Override
    public void visit(Root root) {
        System.out.println(root.getName());
        System.out.println("Right Nodes");
        for (Composite composite : root.getChilds()) {
            if (composite.getSide() == Side.RIGHT) {
                composite.accept(this);
            }
        }
        System.out.println("Left Nodes");
        for (Composite composite : root.getChilds()) {
            if (composite.getSide() == Side.LEFT) {
                composite.accept(this);
            }
        }
    }
}
