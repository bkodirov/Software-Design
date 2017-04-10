package composite;

/**
 * Created by Beka on 10.04.17.
 */
public class BLeaf extends Component {
    public BLeaf(String title) {
        super(title);
    }

    public BLeaf() {
        super(null);
    }


    @Override
    public void render() {
        if (list.isEmpty()) {
            System.out.println("This is b leaf with name "+title);
        } else {
            System.out.println("This is a b root");
            for (Component component : list) {
                component.render();
            }
        }
    }
}
