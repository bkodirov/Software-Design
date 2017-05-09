package abstract_factory.task;

import abstract_factory.task.adult.AdultsFactory;
import abstract_factory.task.bussiness.BusinessFactory;
import abstract_factory.task.kids.KidsFactory;

import java.util.ArrayList;
import java.util.List;

public class GiftPack {
    private final AbstractFactory factory;
    private List<AbstractGiftItem> abstractGiftItems = new ArrayList<>();
    private final Address shippingAddress;
    private final String packType; //"Business", "Adults", or "Kids" //...

    public GiftPack(Address shippingAddress, String type) {
        this.shippingAddress = shippingAddress;
        this.packType = type;
        switch (type) {
            case "Business":
                factory = new BusinessFactory();
                break;
            case "Adults":
                factory = new AdultsFactory();
                break;
            case "Kids":
                factory = new KidsFactory();
                break;
            default:
                throw new IllegalArgumentException("There is no type for" + type);
        }
    }


    public void addGift(PackType type) {
        factory.getGiftItem(type);
    }
}