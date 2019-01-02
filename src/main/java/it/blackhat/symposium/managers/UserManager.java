package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.User;

import java.sql.SQLException;
import java.util.Optional;

/**
 * @author Giuseppe Madonna
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
}
