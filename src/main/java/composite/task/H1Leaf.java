package composite.task;

/**
 * Created by Beka on 10.04.17.
 */
public class H1Leaf extends Component {
    public H1Leaf(String title) {
        super(title);
    }

    @Override
    public void render() {
        System.out.println("This is b H1 leaf with name "+title);
    }
}
