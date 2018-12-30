package it.blackhat.symposium.models;

import java.sql.Date;

/**
 * Interface for represent Question resource
 *
 * @author Przemyslaw Szopian
 */
public interface Question {

    /**
     * Retrieve the id of the question
     *
     * @return the id
     */
    String getId();

    /**
     * Retrieve the content of the question
     *
     * @return the content
     */
    String getContent();

    /**
     * Retrieve the creation date of the question
     *
     * @return the creationDate
     */
    Date getCreationDate();

    /**
     * Retrieve the last modify date of the question
     *
     * @return the last modify date
     */
    Date getLastUpdate();

    /**
     * Retrieve the numSegn of the question
     *
     * @return the numSegn
     */
    int getNumReports();

    /**
     * Retrieve the title of the question
     *
     * @return the title
     */
    String getTitle();

    /**
     * Retrieve the author of the question
     *
     * @return the author
     */
    String getAuthor();

   

    /**
     * Change the last modify date of the question
     *
     * @param lastUpdate new last modify date
     *
     */
    void setLastUpdate(Date lastUpdate);

   
}
