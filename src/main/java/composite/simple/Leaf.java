package composite.simple;

/**
 * Leaf is a component that does not contain others
 */
public class Leaf extends Component {
    private String number;

    public Leaf(String number, String title) {
        super(title);
        this.number = number;
    }

    //for addItem() method, print a message “cannot add child”
    public void print() {
        System.out.println("Leaf [isbn=" + number + ", title=" + title + "]");
    }
}