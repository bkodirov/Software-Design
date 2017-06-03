package abstract_factory.task.adult;

import abstract_factory.task.AbstractBoxGift;

/**
 * Created by Beka on 10.04.17.
 */
public class AdultBoxGift extends AbstractBoxGift{
    public AdultBoxGift() {
        super("Plain Paper", "");
    }

    @Override
    public float getCost() {
        return 0.25f;
    }
}
