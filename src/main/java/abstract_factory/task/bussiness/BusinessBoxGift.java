package abstract_factory.task.bussiness;

import abstract_factory.task.AbstractBoxGift;

/**
 * Created by Beka on 10.04.17.
 */
public class BusinessBoxGift extends AbstractBoxGift{
    public BusinessBoxGift() {
        super("Hard Plastic", "");
    }

    @Override
    public float getCost() {
        return 1f;
    }
}
