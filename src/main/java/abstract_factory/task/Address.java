package abstract_factory.task;

public class Address {
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipcode;

    public Address(String street1, String street2, String city, String state, String zipcode) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    //This constructor is just for make life easier
    public Address() {
    }
}