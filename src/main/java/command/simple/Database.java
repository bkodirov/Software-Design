package command.simple;

/**
 * Receiver class that executes a command.
 */
public class Database {
    /**
     * save person object into the database
     *
     * @param person
     * @return
     */
    public boolean save(Person person) {
        try {
            return savePerson(person);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * remove person from the database
     *
     * @param person
     * @return
     */
    public boolean remove(Person person) {
        try {
            return removePerson(person);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * send an 'insert' SQL query to the database and return a true or false value;
     *
     * @param p
     * @return
     * @throws Exception
     */
    private boolean savePerson(Person p) throws Exception {
        return false;
    }

    /**
     * send a delete SQL query to the database and return a true or false value;
     *
     * @param p
     * @return
     * @throws Exception
     */
    private boolean removePerson(Person p) throws Exception {
        return true;
    }
}