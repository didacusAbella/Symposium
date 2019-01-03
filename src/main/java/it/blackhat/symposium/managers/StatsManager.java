package it.blackhat.symposium.managers;

import java.sql.SQLException;
import java.util.Date;

//import java.util.Optional;
//import it.blackhat.symposium.models.Stats;

/**
 * @author Parrilli Carminantonio
 *
 */
public interface StatsManager {
    /**
     * Find the stats of the site given a year
     * @param year the year we want the stats to come from
     * @return the stats of a given year
     * @throws SQLException if db errors occurred
     */
    int incrementSignedUpUsers(Date year) throws SQLException;
}
