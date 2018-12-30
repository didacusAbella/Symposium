package it.blackhat.symposium.models;

/**
 * Interface for represent Admin resource
 *
 * @author Diego Avella
 * @since 1.0
 * @version 1.0
 */
public interface Admin {

    /**
     * Retrieve the username of the admin
     *
     * @return the username
     */
    String getUsername();

    /**
     * Retrieve the password of the admin
     *
     * @return the password
     */
    String getPassword();

    /**
     * Change the username of the admin
     *
     * @param username the new username
     */
    void setUsername(String username);

    /**
     * Change the password of the admin
     *
     * @param password the new password;
     */
    void setPassword(String password);

}
