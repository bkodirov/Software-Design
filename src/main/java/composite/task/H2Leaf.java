package composite.task;

/**
 * Created by Beka on 10.04.17.
 */
public class H2Leaf extends Component {
    public H2Leaf(String title) {
        super(title);
    }

    @Override
    public void render() {
        System.out.println("This is b H2 leaf with name "+title);
    }
}
