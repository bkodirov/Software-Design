package facade;

import java.sql.SQLException;

/**
 * Created by Beka on 16.04.17.
 */
public class DataFetchException extends Exception {
    public DataFetchException(String message) {
        super(message);
    }

    public DataFetchException(Exception e) {
        super(e);
    }
}
