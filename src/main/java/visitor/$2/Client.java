package visitor.$2;

/**
 * Created by Beka on 24.04.17.
 */
public class Client {
    public static void main(String[] args) {
        NodeVisitor visitor = new DisplayNodeVisitor();
        Root r = new Root();

        Node aa1 = new Node("AA1", Side.RIGHT);
        Node aa2 = new Node("AA2", Side.RIGHT);
        Node aa3 = new Node("AA3", Side.RIGHT);
        Node a1 = new Node("A1", Side.RIGHT);
        a1.addChild(aa1, aa2, aa3);

        Node a2 = new Node("A2", Side.RIGHT);
        Node a = new Node("A", Side.RIGHT);
        a.addChild(a1, a2);

        Node b1 = new Node("B1", Side.RIGHT);
        Node b2 = new Node("B2", Side.RIGHT);
        Node b = new Node("B", Side.RIGHT);
        b.addChild(b1, b2);

        Node c1 = new Node("C1", Side.RIGHT);
        Node c2 = new Node("C2", Side.RIGHT);
        Node c = new Node("C", Side.RIGHT);
        c.addChild(c1, c2);
        r.addChild(a, b, c);

        Node d = new Node("D", Side.LEFT);
        Node d1 = new Node("D1", Side.LEFT);
        Node d2 = new Node("D2", Side.LEFT);
        d.addChild(d1, d2);

        Node e1 = new Node("E1", Side.LEFT);
        Node e2 = new Node("E2", Side.LEFT);
        Node e3 = new Node("E3", Side.LEFT);
        Node e = new Node("E", Side.LEFT);
        e.addChild(e1, e2, e3);

        Node f1 = new Node("F1", Side.LEFT);
        Node f2 = new Node("F2", Side.LEFT);
        Node f = new Node("F", Side.LEFT);
        f.addChild(f1, f2);

        r.addChild(d, e, f);
        r.accept(visitor);
    }
}
