package it.blackhat.symposium.models;

import java.sql.Date;

/**
 * Concrete implementation of Answer Interface
 *
 * @author Przemyslaw Szopian
 */
public class AnswerModel implements Answer {

    private String id, content, title, author;
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
     * @param author author of the answer
     */
    public AnswerModel(String id, String content, String title, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
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
    public String getAuthor() {
        return author;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }
}