package proxy;

/**
 * Choice 1: Implement a synchronization proxy discussed in Scenario 3.
 * Suppose the Table class implements the ITable interface
 * <p>
 * A class library provides a Table class, but does not provide a capability to allow clients to lock individual
 * table rows. We do not have the source code for this class library, but we have complete documentation and know
 * the interface of the Table class. How can we provide a row locking capability for the Table class?
 * Solution: A Synchronization Proxy, which uses a locking mechanism to control the number of clients that simultaneously
 * access the server or the real object.
 *
 * This is a Subject. Subject defines the common interface for RealSubject and Proxy
 * so that a Proxy can be used anywhere a RealSubject is expected.
 */
public interface ITable {
    public int numOfRows();

    IRow getRow(int rowNum);

    void addRow(IRow row, int rowNum); //add row at the end public void modifyRow(int rowNum, IRow row);

    void deleteRow(int rowNum);
}
