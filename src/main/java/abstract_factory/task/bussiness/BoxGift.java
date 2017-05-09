package abstract_factory.task.bussiness;

import abstract_factory.task.AbstractGiftItem;
import abstract_factory.task.PackType;

/**
 * Created by Beka on 10.04.17.
 */
public class BoxGift extends AbstractGiftItem {
    public BoxGift() {
        super(PackType.BOX, "Hard Plastic", 1);
    }
}
