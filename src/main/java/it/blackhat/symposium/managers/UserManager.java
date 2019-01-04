package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.User;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * @author Giuseppe Madonna, SDelPiano
 */
public interface UserManager {
    /**
     * Find accounts by email
     *
     * @param email email of the user
     * @return a boolean valor, true if the email exists, otherwhise false
     * @throws SQLException if it encounter an error
     */
    Optional<User> findEmail(String email) throws SQLException;

    /**
     * Update the user information
     *
     * @param user user data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     */
    int editProfile(User user) throws SQLException;

    /**
     * Delete the user account
     *
     * @param user user data
     * @return the number of row deleted
     * @throws SQLException if it encounter an error
     */
    int deleteAccount(User user) throws SQLException;

    /**
     * Find out if the user is registered in the database
     *
     * @param username username of the user
     * @param pass     password of the user
     * @return a User object that contain the find user data
     * @throws SQLException if it encounter an error
     */
    Optional<User> findUser(String username, String pass) throws SQLException;

    /**
     * Register the user data in the database
     *
     * @param user user data
     * @return the created User
     * @throws SQLException if it encounter an error
     */
    int createUser(User user) throws SQLException;

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
     * Retrieves all users
     *
     * @return a List of tags related to the users
     * @throws SQLException if db error occurred
     */
    List<User> retrieveUsers() throws SQLException;
}