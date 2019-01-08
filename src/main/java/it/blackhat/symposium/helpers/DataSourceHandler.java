package it.blackhat.symposium.helpers;

import it.blackhat.symposium.managers.ConnectionManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author didacus
 */
public class DataSourceHandler {

    private static Context ctx;
    private static final Log CONNECTION_LOG = LogFactory.getLog(ConnectionManager.class);

    /**
     * Create a default DataSource
     *
     * @return a new datasource
     */
    public static synchronized DataSource createProdutionDataSource() {
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/SymposiumDB");
            return ds;
        } catch (NamingException ex) {
            CONNECTION_LOG.error("Could not create connection", ex);
            return null;
        }
    }

}
