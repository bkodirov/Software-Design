package abstract_factory.task;

import abstract_factory.task.adult.AdultsFactory;
import abstract_factory.task.bussiness.BusinessFactory;
import abstract_factory.task.kids.KidsFactory;

import java.util.ArrayList;
import java.util.List;

public class GiftPack {
    private final AbstractFactory factory;
    private List<AbstractGift> giftList= new ArrayList<>();
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
    public void addBagGift(){
        giftList.add(factory.getBag());
    }
    public void addBoxGift(){
        giftList.add(factory.getBox());

    }
    public void addWrapGift(){
        giftList.add(factory.getWrap());
    }


    public void calculate(){
        float sum = 0f;
        System.out.println("--------------- ####---------------");
        System.out.println("Pack type is "+packType);
        System.out.println("Shipping address: "+ shippingAddress.toString());
        System.out.println("--------------- ####---------------");
        for (AbstractGift gift : giftList) {
            sum+=gift.getCost();
            System.out.println(gift.getName());
        }
        System.out.printf("Total cost is %f", sum);
    }
}