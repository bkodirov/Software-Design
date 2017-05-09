package abstract_factory.task.bussiness;

import abstract_factory.task.AbstractFactory;
import abstract_factory.task.AbstractGiftItem;
import abstract_factory.task.PackType;

/**
 * Created by Beka on 10.04.17.
 */
public class BusinessFactory implements AbstractFactory {
    @Override
    public AbstractGiftItem getGiftItem(PackType packType) {
        switch (packType) {
            case BAG:
                return new BaGift();
            case BOX:
                return new BoxGift();
            case WRAP:
                return new WrapGift();
        }
        return null;
    }
}
