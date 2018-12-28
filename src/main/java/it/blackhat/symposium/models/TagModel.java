/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.blackhat.symposium.models;

/**
 * Concrete implementation of Tag Interface
 *
 * @author Rodzinka
 */
public class TagModel implements Tag {

    private String id, tagName;

    /**
     * create an empty TagModel
     */
    public TagModel() {
        super();
    }

    /**
     * Create a new Tag with id and name.
     *
     * @param id id of the tag
     * @param tagName tag name of the tag
     */
    public TagModel(String id, String tagName) {
        this.id = id;
        this.tagName = tagName;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTagName() {
        return tagName;
    }
}
