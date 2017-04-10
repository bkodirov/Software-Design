package prototype;

/**
 * Created by Beka on 10.04.17.
 */
public class Client {

    public static void main(String[] args) {
        Employee s=new Employee();
        Address a=new Address();
        a.zipcode = "123123";
        s.id=2;
        s.address = a;

        Employee[] arr=new Employee[2];
        arr[0]=s;
        arr[1]=s;

        Employee[] arr2=new Employee[3];
        Employee pr=new Employee();
        pr.id=3;
        arr2[0]=pr;
        arr2[1]=pr;
        arr2[2]=pr;

        s.staff = arr2;

        Employee e=new Employee();
        e.id=1;
        e.staff = arr;

        try {
//            System.out.println(e.toString());
            System.out.println(e.clone().toString());
        } catch (CloneNotSupportedException e1) {
            e1.printStackTrace();
        }
    }
}
