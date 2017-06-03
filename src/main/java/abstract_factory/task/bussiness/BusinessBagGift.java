package abstract_factory.task.bussiness;

import abstract_factory.task.AbstractBagGift;

/**
 * Created by Beka on 10.04.17.
 */
public class BusinessBagGift extends AbstractBagGift{

    public BusinessBagGift() {
        super("Merchant Collection", "");
    }

    @Override
    public float getCost() {
        return 0.5f;
    }
}
