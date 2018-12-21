package it.blackhat.symposium.models;

import java.sql.Date;

/**
 * Interface for represent User resource
 *
 * @author Giuseppe Madonna
 */
public interface User {

    /**
     * Retrieve the username of the user
     *
     * @return the username
     */
    String getUsername();

    /**
     * Retrieve the first name of the user
     *
     * @return the first name
     */
    String getFirstName();

    /**
     * Retrieve the last name of the user
     *
     * @return the last name
     */
    String getLastName();

    /**
     * Retrieve the e-mail of the user
     *
     * @return the e-mail
     */
    String getEmail();

    /**
     * Retrieve the password of the user
     *
     * @return the password
     */
    String getPassword();

    /**
     * Retrieve the degree of the user
     *
     * @return a boolean value that represents the user's degree
     */
    Boolean getTypeGrad();

    /**
     * Retrieve the date until the user ban is valid
     *
     * @return the date of user's ban ending
     */
    Date getBanLastDate();

    /**
     * Change the first name of the user
     *
     * @param firstName the new first name
     */
    void setFirstName(String firstName);

    /**
     * Change the last name of the user
     *
     * @param lastName the new last name
     */
    void setLastName(String lastName);

    /**
     * Change the e-mail of the user
     *
     * @param email the new e-mail
     */
    void setEmail(String email);

    /**
     * Change the password of the user
     *
     * @param password the new password
     */
    void setPassword(String password);

    /**
     * Change degree of the student
     *
     * @param typeGrad the new degree
     */
    void setTypeGrad(boolean typeGrad);

    /**
     * Change the date until the user is banned
     *
     * @param banLastDate new ban date
     */
    void setBanLastDate(Date banLastDate);

}
