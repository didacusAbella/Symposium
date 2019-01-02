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
    int getId();

    /**
     * Set a new question id
     *
     * @param id a new question id
     */
    void setId(int id);

    /**
     * Retrieve the content of the question
     *
     * @return the content
     */
    String getContent();

    /**
     * Set a new question content
     *
     * @param content the new question content
     */
    void setContent(String content);

    /**
     * Retrieve the last modify date of the question
     *
     * @return the last modify date
     */
    Date getLastUpdate();

    /**
     * Change the last modify date of the question
     *
     * @param lastUpdate the last update of the question
     */
    void setLastUpdate(Date lastUpdate);

    /**
     * Retrieve the creation date of the question
     *
     * @return the creationDate
     */
    Date getCreationDate();

    /**
     * Set a new question's creation date
     *
     * @param creationDate a new creation date
     */
    void setCreationDate(Date creationDate);

    /**
     * Retrieve the title of the question
     *
     * @return the title
     */
    String getTitle();

    /**
     * Set a new question title
     *
     * @param title new title
     */
    void setTitle(String title);

    /**
     * Retrieve the author of the question
     *
     * @return the author of the question
     */
    String getUserFk();

    /**
     * Set a new question's author
     *
     * @param userFk the new author
     */
    void setUserFk(String userFk);

    /**
     * Retrieve the number of question's reports
     *
     * @return the number of question reports
     */
    int getNumReports();

    /**
     * Set a new number of reports for the question
     *
     * @param numReports the number of reports
     */
    void setNumReports(int numReports);


}
