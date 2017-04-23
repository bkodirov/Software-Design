package flyweight;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Beka on 23.04.17.
 */
public class FlyweightFactory {
    private static final Map<Integer, CustomerFlyweight> pool = new HashMap<>();

    public static CustomerFlyweight getCustomer(Image area) {
        if (pool.containsKey(area.hashCode())) {
            return pool.get(area.hashCode());
        } else {
            CustomerFlyweight flyweight = new CustomerFlyweight(area);
            pool.put(area.hashCode(), flyweight);
            return flyweight;
        }
    }
}
