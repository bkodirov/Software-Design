package proxy.task;

/**
 * Created by Beka on 09.04.17.
 */
public class Client {
    public static void main(String[] args) {
        final ITable table = new TableProxy();
        table.addRow(new Row(), 1);
        table.deleteRow( 1);
    }
    static class Row implements IRow{

    }
}
