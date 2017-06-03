package abstract_factory.task.kids;

import abstract_factory.task.AbstractWrapGift;

/**
 * Created by Beka on 10.04.17.
 */
public class KidsWrapGift extends AbstractWrapGift{
    public KidsWrapGift() {
        super("Happy Kid", "");
    }

    @Override
    public float getCost() {
        return 0.1f;
    }
}
