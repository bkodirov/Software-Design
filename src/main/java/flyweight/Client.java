package flyweight;

/**
 * Created by Beka on 23.04.17.
 */
public class Client {
    public static void main(String[] args) {
        int customerId = (int) Math.random() * 31;
        String firstName = "Name";
        String lastName = "Last name";
        Address residenceAddress = new Address();
        HealthProfile profile = new HealthProfile();

        Image heavyObject = new Image();

        CustomerFlyweight customer = FlyweightFactory.getCustomer(heavyObject);
        customer.setData(customerId, firstName, lastName, residenceAddress, profile);

        CustomerHeavyweight heavyweight = new CustomerHeavyweight(customerId, firstName, lastName, residenceAddress, profile, heavyObject);
    }
}
