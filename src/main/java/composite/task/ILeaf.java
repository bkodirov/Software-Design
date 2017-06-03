package composite.task;

/**
 * Created by Beka on 10.04.17.
 */
public class ILeaf extends Component {
    public ILeaf(String title) {
        super(title);
    }

    @Override
    public void render() {
        System.out.println("This is b i leaf with name "+title);
    }
}
