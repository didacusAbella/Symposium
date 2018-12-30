package it.blackhat.symposium.models;

import java.sql.Date;

/**
 * Concrete implementation of Answer Interface
 *
 * @author Przemyslaw Szopian
 */
public class AnswerModel implements Answer {

    private String id, content;
    Date creationDate;

    /**
     *
     * Creates an empty Answer
     */
    public AnswerModel() {
        super();
    }

    /**
     * Create a new Answer with id, content, title and author.
     *
     * @param id id of the answer
     * @param content content of the answer
     * @param title title of the answer
     */
    public AnswerModel(String id, String content, String title) {
        this.id = id;
        this.content = content;
       
        
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getContent() {
        return content;
    }

   

    @Override
    public Date getCreationDate() {
        return creationDate;
    }
}