package template.simple;

/**
 * Abstract class with a „skeleton‟ implementation of an algorithm.  (In a template method, the parent
 * class calls the operations of a subclass and not the other way around.) This is an inverted control
 * structure that's sometimes referred to as "the Hollywood principle," as in, "Don't call us, we'll call you".
 */
public abstract class AOrderProcessor {
    public final void processOrder(Order order) {
        String orderDetails = getOrderDetails(order);
        float shippingFee = getShippingFee(order);
        int shippingTime = getShippingTime(order);
        sendConfirmation(orderDetails, shippingFee, shippingTime);
    }

    //by weight, volume or whichever-is-higher depending on partnering agent
    public abstract float getShippingFee(Order order);

    //by distance and shipment type(air, sea or land...)
    public abstract int getShippingTime(Order order);

    public abstract void sendConfirmation(String orderDetails,
                                          float shippingFee, int shippingTime);

    private String getOrderDetails(Order order) {
        String od = "";
        od += "Thank you for shopping with us!";
        od += "Here is the detailed information on your order:";
        // more detailed information item by item here from 'order' object.
        return od;
    }
}
