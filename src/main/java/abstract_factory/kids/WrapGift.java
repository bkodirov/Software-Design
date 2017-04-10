package abstract_factory.kids;

import abstract_factory.AbstractGiftItem;
import abstract_factory.PackType;

/**
 * Created by Beka on 10.04.17.
 */
public class WrapGift extends AbstractGiftItem {
    public WrapGift() {
        super(PackType.WRAP, "Happy Kid", 0.10);
    }
}
