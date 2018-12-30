package it.blackhat.symposium.models;

import java.sql.Date;

/**
 * Concrete implementation of Question Interface
 *
 * @author Przemyslaw Szopian
 */
public class QuestionModel implements Question {

    private String id, content, title, author;
    Date creationDate, lastUpdate;
    private int numSegn;

    /**
     * Concrete Implementation of Question Interface
     *
     * @author Diego Avella
     */
    public QuestionModel() {
        super();
    }

    /**
     * Create a new Question with id, content, numSegn, title, author and tag.
     *
     * @param id id of the question
     * @param content content of the question
     * @param numSegn numSegn of the question
     * @param title title of the question
     * @param author author of the question
     * @param tag tag of the question
     */
    public QuestionModel(String id, String content, int numSegn, String title, String author,
            String tag) {
        this.id = id;
        this.content = content;
        this.numSegn = numSegn;
        this.title = title;
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
    public String getTitle() {
        return title;
    }

    @Override
    public int getNumReports() {
        return numSegn;
    }

    /**
     *
     * @return
     */
    @Override
    public String getAuthor() {
        return author;
    }

  

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public Date getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }





	
}
