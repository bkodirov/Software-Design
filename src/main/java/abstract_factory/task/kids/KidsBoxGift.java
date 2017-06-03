package abstract_factory.task.kids;

import abstract_factory.task.AbstractBoxGift;

/**
 * Created by Beka on 10.04.17.
 */
public class KidsBoxGift extends AbstractBoxGift{
    public KidsBoxGift() {
        super("Cartoon", "");
    }

    @Override
    public float getCost() {
        return 0.5f;
    }
}
