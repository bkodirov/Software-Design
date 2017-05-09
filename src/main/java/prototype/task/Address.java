package prototype.task;

/**
 * Created by Beka on 10.04.17.
 */
public class Address {
    public String streetAddress;
    public String city;
    public String state;
    public String zipcode;

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
