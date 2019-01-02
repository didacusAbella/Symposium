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
 * @author 2Deimos
 */
public class TagModel implements Tag {

    private String name;
    private int id;

    /**
     * create an empty TagModel
     */
    public TagModel() {
        super();
    }

    /**
     * Create a new Tag with id and name.
     *
     * @param id   id of the tag
     * @param name tag name of the tag
     */
    public TagModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
