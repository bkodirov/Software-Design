package composite.task;

/**
 * Created by Beka on 10.04.17.
 */
public class HtmlComposite extends Component {
    public HtmlComposite() {
        super(null);
    }

    @Override
    public void render() {
        System.out.println("This is a Html");
        for (Component component : list) {
            component.render();
        }
    }
}
