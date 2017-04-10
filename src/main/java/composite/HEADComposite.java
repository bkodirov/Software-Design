package composite;

/**
 * Created by Beka on 10.04.17.
 */
public class HEADComposite extends Component {
    public HEADComposite() {
        super(null);
    }

    @Override
    public void render() {
        System.out.println("This is a Head");
        for (Component component : list) {
            component.render();
        }
    }
}
