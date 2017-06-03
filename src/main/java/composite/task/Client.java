package composite.task;

/**
 * Created by Beka on 10.04.17.
 */
public class Client {
    public static void main(String[] args) {
        Component html = new HtmlComposite();
        Component body = new BodyComposite();
        Component head = new HEADComposite();
        html.addChild(head);
        html.addChild(body);

        Component titleLeaf = new TITLELeaf("Your Title Here");
        head.addChild(titleLeaf);

        Component a= new ALeaf("Link name", "http://somegreatsite.com");
        Component h1= new H1Leaf("This is a Header");
        Component h2= new H2Leaf("This is a Medium Header");
        Component b= new BLeaf("This is a new paragraph");
        Component b2= new BLeaf("This is a new paragraph");
        Component i= new ILeaf("This is a new sentence without a paragraph break, in bold italics.");
        b2.addChild(i);
        body.addChild(a);
        body.addChild(h1);
        body.addChild(h2);
        body.addChild(b);
        body.addChild(b2);
        html.render();
    }
}
