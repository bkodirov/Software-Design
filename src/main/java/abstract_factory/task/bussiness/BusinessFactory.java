package abstract_factory.task.bussiness;

import abstract_factory.task.AbstractBagGift;
import abstract_factory.task.AbstractBoxGift;
import abstract_factory.task.AbstractFactory;
import abstract_factory.task.AbstractWrapGift;

/**
 * Created by Beka on 10.04.17.
 */
public class BusinessFactory implements AbstractFactory {
    @Override
    public AbstractBagGift getBag() {
        return new BusinessBagGift();
    }

    @Override
    public AbstractBoxGift getBox() {
        return new BusinessBoxGift();
    }

    @Override
    public AbstractWrapGift getWrap() {
        return new BusinessWrapGift();
    }
}
