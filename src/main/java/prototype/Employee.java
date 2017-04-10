package prototype;

import java.io.Serializable;
import java.util.Arrays;

public class Employee implements Cloneable, Serializable {
    public int id;
    public String Lastname;
    public String Firstname;
    public Address address;
    public Employee supervisor;
    public Employee staff[];

    /**
     * This is a classic version of the Prototype pattern. This will produce deep copy.
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee obj= (Employee) super.clone();
        return obj;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Lastname='" + Lastname + '\'' +
                ", Firstname='" + Firstname + '\'' +
                ", address='" + address + '\'' +
                ", supervisor=" + supervisor +
                ", \nstaff=" + Arrays.toString(staff) +'\n'+
                '}';
    }

}