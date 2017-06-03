package abstract_factory.task.adult;

import abstract_factory.task.AbstractBagGift;
import abstract_factory.task.AbstractBoxGift;
import abstract_factory.task.AbstractFactory;
import abstract_factory.task.AbstractWrapGift;

/**
 * Created by Beka on 10.04.17.
 */
public class AdultsFactory implements AbstractFactory {
    @Override
    public AbstractBagGift getBag() {
        return new AdultBagGift();
    }

    @Override
    public AbstractBoxGift getBox() {
        return new AdultBoxGift();
    }

    @Override
    public AbstractWrapGift getWrap() {
        return new AdultWrapGift();
    }
}
