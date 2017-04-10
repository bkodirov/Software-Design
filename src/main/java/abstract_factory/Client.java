package abstract_factory;

/**
 * Created by Beka on 10.04.17.
 */
public class Client {
    public static void main(String[] args) {
        Address shippingAddress=new Address();
        GiftPack pack=new GiftPack(shippingAddress, "");

    }
}
