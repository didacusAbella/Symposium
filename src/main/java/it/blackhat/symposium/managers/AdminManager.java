package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Admin;

import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

/**
 * @author Diego Avella
 */
public interface AdminManager {

    /**
     * Find an admin given username and password
     *
     * @param username the admin's username
     * @param password tha admin's password
     * @return an instance of admin
     * @throws SQLException if db errors occurred
     */
    Optional<Admin> findAdmin(String username, String password) throws SQLException;


    /**
     * Ban an user from the platform
     *
     * @param time  the duration of the ban
     * @param email the e-mail of the user
     * @return true if the operation go well, false otherwise
     * @throws SQLException if db error occured
     */
    int banUser(Date time, String email) throws SQLException;

    /**
     * Return a report of from the db
     *
     * @param year the year of the report
     * @return true if the operartion go well, false otherwise
     * @throws SQLException if db errors occured
     */
    Optional<String> genReport(String year) throws SQLException;
}
