package composite.simple;

/**
 * Client
 */
public class Client {
    public static void main(String[] args) {
        Component root = new Composite("root");
        Component leaf1 = new Leaf("1", "leaf1");
        Component comp = new Composite("composite");
        Component leaf2 = new Leaf("2", "leaf2");
        comp.addItem(leaf2);
        root.addItem(leaf1);
        root.addItem(comp);
    }
}