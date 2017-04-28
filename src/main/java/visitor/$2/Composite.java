package visitor.$2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beka on 24.04.17.
 */
public abstract class Composite implements Component {
    private List<Composite> compositeList = new ArrayList<>();
    private final String name;
    private final Side side;

    public Composite(String name, Side side) {
        this.name = name;
        this.side = side;
    }

    public void addChild(Composite... composites) {
        for (Composite composite : composites) {
            compositeList.add(composite);
        }
    }

    public List<Composite> getChilds(){
        return  compositeList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Side getSide() {
        return side;
    }
}
