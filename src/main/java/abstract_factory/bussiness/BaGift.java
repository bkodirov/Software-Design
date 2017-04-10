package abstract_factory.bussiness;

import abstract_factory.AbstractGiftItem;
import abstract_factory.PackType;

/**
 * Created by Beka on 10.04.17.
 */
public class BaGift extends AbstractGiftItem {
    public BaGift() {
        super(PackType.BAG, "Merchant Collection", 0.50);
    }
}
