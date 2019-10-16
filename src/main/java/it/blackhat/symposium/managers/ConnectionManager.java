package it.blackhat.symposium.managers;
import javax.sql.DataSource;

/**
 * @author Symposium Group
 */
public abstract class ConnectionManager {

    protected DataSource dataSource;

    /**
     * Create a new Connection Manager with specified DaraSource.
     *
     * @param ds datasource to pass
     */
    public ConnectionManager(DataSource ds) {
        dataSource = ds;
    }
}
