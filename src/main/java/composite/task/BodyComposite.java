package composite.task;

/**
 * Created by Beka on 10.04.17.
 */
public class BodyComposite extends Component {
    public BodyComposite() {
        super(null);
    }

    @Override
    public void render() {
        System.out.println("This is a Body");
        for (Component component : list) {
            component.render();
        }
    }
}
