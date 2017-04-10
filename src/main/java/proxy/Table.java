package proxy;

/**
 * Created by Beka on 09.04.17.
 * RealSubject
 * - defines the real object that the proxy represents.
 * Consider this is Concret implentation of ITable interface. Consider this class is driven from library
 */
public class Table implements ITable {

    public int numOfRows() {
        return 0;
    }

    public IRow getRow(int rowNum) {
        return null;
    }

    public void addRow(IRow row, int rowNum) {
        System.out.println("Row " + rowNum + " added");
    }

    public void deleteRow(int rowNum) {
        System.out.println("Row " + rowNum + " deleted");
    }
}
