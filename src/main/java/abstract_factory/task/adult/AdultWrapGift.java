package abstract_factory.task.adult;

import abstract_factory.task.AbstractWrapGift;

/**
 * Created by Beka on 10.04.17.
 */
public class AdultWrapGift extends AbstractWrapGift{
    public AdultWrapGift() {
        super("Everyday Value", "");
    }

    @Override
    public float getCost() {
        return 0;
    }
}
