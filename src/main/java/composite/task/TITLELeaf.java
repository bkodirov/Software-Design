package composite.task;

/**
 * Created by Beka on 10.04.17.
 */
public class TITLELeaf extends Component {
    public TITLELeaf(String title) {
        super(title);
    }

    @Override
    public void render() {
        System.out.println("This is b TITLE leaf with name "+title);
    }
}
