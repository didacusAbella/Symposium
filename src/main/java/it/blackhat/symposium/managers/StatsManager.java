package it.blackhat.symposium.managers;

import java.sql.SQLException;
import java.util.Optional;

import it.blackhat.symposium.models.Stats;

/**
 * An interface for the manager of the Stats
 * @author Parrilli Carminantonio
 *
 */
public interface StatsManager {
    /**
     * 
     * @param interestedYear  the year we're interest  from getting the stats
     * @return the stats from the database
     * @throws SQLException if db errors occured
     */
    Optional<Stats> getStats(int interestedYear)throws SQLException;
    /**
     * Return the number of users in the database
     * @param interestedYear the year we want the number of subscribed users to come from
     * @return the number of users in the database
     * @throws SQLException if db errors occurred
     */
    int getNumberUsers(int interestedYear) throws SQLException;
    /**
     * The method returns the number of reports in the database
     * @param interestedYear the year we want the number of report generated to come from
     * @return the number of reports in a particular year
     * @throws SQLException if db errors occurred
     */
    int getNumberReports(int interestedYear) throws SQLException;
    /**
     * The method returns how many banned users are on the site
     * @param interestedYear the year we want to know how many banned users are still there
     * @return the number of banned users
     * @throws SQLException if db errors occurred
     */
    int getBannedUsers(int interestedYear) throws SQLException;
    /**
     * @param interestedYear the date to insert the stats
     * @return the number of rows updated
     * @throws SQLException if db errors occurred
     */
    int createStats(int interestedYear) throws SQLException;
}
