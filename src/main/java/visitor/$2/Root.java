package visitor.$2;

/**
 * Created by Beka on 24.04.17.
 */
public class Root extends Composite {
    public Root() {
        super("Topic", Side.NONE);
    }

    @Override
    public int accept(NodeVisitor visitor) {
        int totalCount = 1;
        System.out.println(getName());
        System.out.println("Right Nodes");
        for (Composite composite : compositeList) {
            if (composite.getSide() == Side.RIGHT) {
                int count = composite.accept(visitor);
                totalCount+=count;
                System.out.println(String.format("%d %s nodes", count, composite.getName().charAt(0)));
            }
        }
        System.out.println("Left Nodes");
        for (Composite composite : compositeList) {
            if (composite.getSide() == Side.LEFT) {
                composite.accept(visitor);
                int count = composite.accept(visitor);
                totalCount+=count;
                System.out.println(String.format("%d %s nodes", count, composite.getName().charAt(0)));
            }
        }
        return totalCount;
    }
}
