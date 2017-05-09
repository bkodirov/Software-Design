package abstract_factory.task.kids;

import abstract_factory.task.AbstractGiftItem;
import abstract_factory.task.PackType;

/**
 * Created by Beka on 10.04.17.
 */
public class WrapGift extends AbstractGiftItem {
    public WrapGift() {
        super(PackType.WRAP, "Happy Kid", 0.10);
    }
}
