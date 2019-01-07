package it.blackhat.symposium.managers;

import it.blackhat.symposium.helpers.DataSourceHandler;
import javax.sql.DataSource;

/**
 * @author Symposium Group
 */
public abstract class ConnectionManager {

    protected DataSource dataSource;

    /**
     * Create a new Connection Manager with specified DaraSource. Use it in
     * testing environment for configure a mock DB.
     *
     * @param ds datasource to pass
     */
    public ConnectionManager(DataSource ds) {
        dataSource = ds;
    }

    /**
     * Create a prebuild ConnectionManager with production Datasource configured
     */
    public ConnectionManager() {
        this(DataSourceHandler.createProdutionDataSource());
    } 
}
