package abstract_factory.task.adult;

import abstract_factory.task.AbstractBagGift;

/**
 * Created by Beka on 10.04.17.
 */
public class AdultBagGift extends AbstractBagGift{

    public AdultBagGift() {
        super("Reusable Shopper", "");
    }

    @Override
    public float getCost() {
        return 0;
    }
}
