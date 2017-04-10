package abstract_factory.bussiness;

import abstract_factory.AbstractGiftItem;
import abstract_factory.PackType;

/**
 * Created by Beka on 10.04.17.
 */
public class BoxGift extends AbstractGiftItem {
    public BoxGift() {
        super(PackType.BOX, "Hard Plastic", 1);
    }
}
