package abstract_factory.task.kids;

import abstract_factory.task.*;

/**
 * Created by Beka on 10.04.17.
 */
public class KidsFactory implements AbstractFactory {

    @Override
    public AbstractBagGift getBag() {
        return new KidsBagGift();
    }

    @Override
    public AbstractBoxGift getBox() {
        return new KidsBoxGift();
    }

    @Override
    public AbstractWrapGift getWrap() {
        return new KidsWrapGift();
    }
}
