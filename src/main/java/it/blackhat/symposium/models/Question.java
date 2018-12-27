/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    Date getLastModDate();

    /**
     * Retrieve the numSegn of the question
     *
     * @return the numSegn
     */
    int getNumSegn();

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
     * Retrieve the tag of the question
     *
     * @return the tag
     */
    String getTag();

    /**
     * Change the last modify date of the question
     *
     * @param lastDate new last modify date
     *
     */
    void setLastModDate(Date lastDate);

    /**
     * Change the tag of the question
     *
     *
     * @param tag new tag
     */
    void setTag(String tag);
}
