package composite.task;

/**
 * Created by Beka on 10.04.17.
 */
public class ALeaf extends Component {
    private final String href;

    public ALeaf(String title, String href) {
        super(title);
        this.href = href;
    }

    @Override
    public void render() {
        System.out.println("This is b a leaf with name "+title);
    }
}
