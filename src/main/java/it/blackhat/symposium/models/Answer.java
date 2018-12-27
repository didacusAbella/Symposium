/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.blackhat.symposium.models;

import java.sql.Date;

/**
 * Interface for represent Answer resource
 * 
 * @author Przemyslaw Szopian
 */
public interface Answer {
    
    /**
     * Retrieve the id of the answer
     *
     * @return the id
     */
    String getId();
    
    /**
     * Retrieve the content of the answer
     *
     * @return the content
     */
    String getContent();
    
    /**
     * Retrieve the creation date of the answer
     *
     * @return the creation date
     */
    Date getCreationDate();
    
    /**
     * Retrieve the title of the answer
     *
     * @return the title
     */
    String getTitle();
    
    /**
     * Retrieve the author of the answer
     *
     * @return the author
     */
    String getAuthor();
}
