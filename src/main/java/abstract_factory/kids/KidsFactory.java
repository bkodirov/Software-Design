package abstract_factory.kids;

import abstract_factory.AbstractFactory;
import abstract_factory.AbstractGiftItem;
import abstract_factory.PackType;

/**
 * Created by Beka on 10.04.17.
 */
public class KidsFactory implements AbstractFactory {
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
