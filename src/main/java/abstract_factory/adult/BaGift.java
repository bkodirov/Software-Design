package abstract_factory.adult;

import abstract_factory.AbstractGiftItem;
import abstract_factory.PackType;

/**
 * Created by Beka on 10.04.17.
 */
public class BaGift extends AbstractGiftItem {
    public BaGift() {
        super(PackType.BAG, "Reusable Shopper", 0);
    }
}
