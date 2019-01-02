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
     * Retrieve the content of the question
     *
     * @return the content
     */
    String getContent();

    /**
     * Retrieve the last modify date of the question
     *
     * @return the last modify date
     */
    Date getLastUpdate();

    /**
     * Retrieve the creation date of the question
     *
     * @return the creationDate
     */
    Date getCreationDate();


    /**
     * Retrieve the title of the question
     *
     * @return the title
     */
    String getTitle();

    /**
     * Retrieve the author of the question
     *
     * @return the author of the question
     */
    String getUserFk();

    /**
     * Retrieve the number of question's reports
     *
     * @return the number of question reports
     */
    int getNumReports();

    /**
     * Set a new question id
     *
     * @param id a new question id
     */
    void setId(int id);

    /**
     * Set a new question content
     *
     * @param content the new question content
     */
    void setContent(String content);

    /**
     * Set a new question title
     *
     * @param title new title
     */
    void setTitle(String title);

    /**
     * Set a new question's author
     *
     * @param userFk the new author
     */
    void setUserFk(String userFk);

    /**
     * Change the last modify date of the question
     *
     * @param lastUpdate the last update of the question
     */
    void setLastUpdate(Date lastUpdate);

    /**
     * Set a new question's creation date
     *
     * @param creationDate a new creation date
     */
    void setCreationDate(Date creationDate);

    /**
     * Set a new number of reports for the question
     *
     * @param numReports the number of reports
     */
    void setNumReports(int numReports);


}
