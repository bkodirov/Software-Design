package abstract_factory.task.adult;

import abstract_factory.task.AbstractGiftItem;
import abstract_factory.task.PackType;

/**
 * Created by Beka on 10.04.17.
 */
public class BaGift extends AbstractGiftItem {
    public BaGift() {
        super(PackType.BAG, "Reusable Shopper", 0);
    }
}
