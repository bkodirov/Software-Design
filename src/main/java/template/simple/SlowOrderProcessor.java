package template.simple;

/**
 * Implement the Concrete subclass by overriding the abstract methods.
 * <p>
 * for bulky and heavy items but buyers are willing to wait * longer to reduce the shipping cost.
 * Logistics company uses sea containers.
 */
public class SlowOrderProcessor extends AOrderProcessor {
    @Override
    public float getShippingFee(Order order) {
        // calculate shipping cost based on order details return shippingFee;
        return 0;
    }

    @Override
    public int getShippingTime(Order order) {
        // get shipping time based on shipping address return shippingTime;
        return 0;
    }

    @Override
    public void sendConfirmation(String orderDetails, float shippingFee, int shippingTime) {
        // send by email
    }
}