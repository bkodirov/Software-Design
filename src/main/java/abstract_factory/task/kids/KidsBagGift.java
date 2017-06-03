package abstract_factory.task.kids;

import abstract_factory.task.AbstractBagGift;

/**
 * Created by Beka on 10.04.17.
 */
public class KidsBagGift extends AbstractBagGift{

    public KidsBagGift() {
        super("Micky", "");
    }

    @Override
    public float getCost() {
        return 0.25f;
    }
}
