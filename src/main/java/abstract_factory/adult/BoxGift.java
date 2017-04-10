package abstract_factory.adult;

import abstract_factory.AbstractGiftItem;
import abstract_factory.PackType;

/**
 * Created by Beka on 10.04.17.
 */
public class BoxGift extends AbstractGiftItem {
    public BoxGift() {
        super(PackType.BOX, "Plain Paper", 0.25);
    }
}
