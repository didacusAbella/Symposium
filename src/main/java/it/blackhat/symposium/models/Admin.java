package it.blackhat.symposium.models;

/**
 * Interface for represent Admin resource
 *
 * @author Diego Avella
 * @version 1.0
 * @since 1.0
 */
public interface Admin {
    /**
     * Retrieve the id of the admin
     *
     * @return the id
     */
    int getId();

    /**
     * Change the id of the admin
     *
     * @param id the new id
     */
    void setId(int id);

    /**
     * Retrieve the username of the admin
     *
     * @return the username
     */
    String getUsername();

    /**
     * Change the username of the admin
     *
     * @param username the new username
     */
    void setUsername(String username);

    /**
     * Retrieve the password of the admin
     *
     * @return the password
     */
    String getPassword();

    /**
     * Change the password of the admin
     *
     * @param password the new password;
     */
    void setPassword(String password);

}
