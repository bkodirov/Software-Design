package proxy;

/**
 * Created by Beka on 09.04.17.
 * Intent
 * Provide a surrogate or placeholder for another object to control access to it.
 * <p>
 * Motivation
 * To defer the full cost of its creation and initialization until we actually need to use it.
 * There are situations in which a client does not or cannot reference an object directly, but wants to still
 * interact with the object.
 * A proxy object can act as the intermediary between the client and the target object.
 * <p>
 * Applicability
 * Proxy is applicable whenever there is a need for a more versatile or sophisticated reference to an object than a
 * simple pointer. Here are several situations where the Proxy pattern is applicable:
 * <p>
 * a) Remote Proxy - Provides a reference to an object located in a different address space on the same or different machine.
 * b) Protection (Access) Proxy - Provides different clients with different levels of access to a target object.
 * c) Cache Proxy - Provides temporary storage of the results of expensive target operations so that multiple clients can share the results.
 * <p>
 * Structure
 *
 * @see <a href="http://www.cs.mcgill.ca/~hv/classes/CS400/01.hchen/doc/proxy/proxy1.gif">Structure of the pattern</a>
 * Participants
 * a. Proxy
 * - maintains a reference that allows the proxy to access the
 * real subject.
 * - provides an interface identical to Subject's so that a
 * proxy can be substituted for the real subject.
 * - controls access to the real subject and may be
 * responsible for creating and deleting it.
 * - otherresponsibilitiesdependonthekindofproxy:
 * Remote proxies are responsible for encoding a request and its arguments and for sending the encoded request to the real subject in a different address space;
 * Virtual proxies may cache additional information about the real subject so that they can postpone accessing it; Protection proxies check that the caller has the access permissions required to perform a request.
 * b. Subject
 * - defines the common interface for RealSubject and Proxy
 * so that a Proxy can be used anywhere a RealSubject is expected.
 * c. RealSubject
 * - defines the real object that the proxy represents.
 */
public class TableProxy implements ITable {
    private RowindexPool pool = RowindexPool.getInstance();
    private ITable concretTable = new Table();

    public int numOfRows() {
        return concretTable.numOfRows();
    }

    public IRow getRow(int rowNum) {
        synchronized (pool.getIndexWrapper(rowNum)) {
            return concretTable.getRow(rowNum);
        }
    }

    public void addRow(IRow row, int rowNum) {
        synchronized (pool.getIndexWrapper(rowNum)) {
            concretTable.addRow(row, rowNum);
        }
    }

    public void deleteRow(int rowNum) {
        synchronized (pool.getIndexWrapper(rowNum)) {
            concretTable.deleteRow(rowNum);
        }
    }
}
