package abstract_factory.task.bussiness;

import abstract_factory.task.AbstractWrapGift;

/**
 * Created by Beka on 10.04.17.
 */
public class BusinessWrapGift extends AbstractWrapGift{
    public BusinessWrapGift() {
        super("Holiday Surprise", "");
    }

    @Override
    public float getCost() {
        return 0.25f;
    }
}
