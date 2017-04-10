package abstract_factory.bussiness;

import abstract_factory.AbstractGiftItem;
import abstract_factory.PackType;

/**
 * Created by Beka on 10.04.17.
 */
public class WrapGift extends AbstractGiftItem {
    public WrapGift() {
        super(PackType.WRAP, "Holiday Surprise", 0.25);
    }
}
