/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.blackhat.symposium.models;

/**
 * Interface for represent Tag resource
 *
 * @author Przemyslaw Szopian
 */
public interface Tag {

    /**
     * Retrive the id of the tag
     *
     * @return the id
     */
    int getId();

    /**
     * Retrieve the name of the tag
     *
     * @return the name of the tag
     */
    String getTagName();
    
    /**
     * Change the id of the question
     *
     *
     * @param id new id of the tag
     */
    void setId(int id);
    
    /**
     * Change the name of the tag
     *
     *
     *
     * @param tagName
     */
    void setTagName(String tagName);
}
