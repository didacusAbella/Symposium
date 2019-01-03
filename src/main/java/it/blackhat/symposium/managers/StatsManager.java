package it.blackhat.symposium.managers;

import java.sql.SQLException;
import java.util.Date;

//import java.util.Optional;
//import it.blackhat.symposium.models.Stats;

/**
 * An interface for the manager of the Stats
 * @author Parrilli Carminantonio
 *
 */
public interface StatsManager {
    /**
     * Find the stats of the site given a year
     * @param year the year we want the stats to come from
     * @return the numer of rows updated
     * @throws SQLException if db errors occurred
     */
    int incrementSignedUpUsers(Date year) throws SQLException;
    /**
     * Return the number of users in the database
     * @return the number of users in the database
     * @throws SQLException if db errors occurred
     */
    int getNumberUsers() throws SQLException;
}
