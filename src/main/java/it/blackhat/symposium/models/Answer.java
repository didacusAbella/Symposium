package it.blackhat.symposium.models;

import java.sql.Date;

/**
 * Interface for represent Answer resource
 *
 * @author Przemyslaw Szopian
 * @author 2Deimos
 */
public interface Answer {
    /**
     * Retrieve the answer id
     *
     * @return the answer id
     */
    int getId();

    /**
     * Set a new answer id
     *
     * @param id a new answer id
     */
    void setId(int id);

    /**
     * Retrieve the question foreign key
     *
     * @return the question foreign key
     */
    int getQuestionFk();

    /**
     * Set a new question foreign key
     *
     * @param questionFk new question foreign key
     */
    void setQuestionFk(int questionFk);

    /**
     * Retrieve the email of the user as a foreign key
     *
     * @return the user foreign key
     */
    String getUserFk();

    /**
     * Set a new user foreign key
     *
     * @param userFk a new user foreign key
     */
    void setUserFk(String userFk);

    /**
     * Retrieve the content of the answer
     *
     * @return the content of the answer
     */
    String getContent();

    /**
     * Set a new content for the answer
     *
     * @param content a new answer content
     */
    void setContent(String content);


    /**
     * Retrieve the creation date of the answer
     *
     * @return answer's creation date
     */
    Date getCreationDate();

    /**
     * Set a new creation date for the answer
     *
     * @param creationDate a new creation date
     */
    void setCreationDate(Date creationDate);

    /**
     * Retrieve if the answer is chosen as the best one
     *
     * @return the state of the answer
     */
    boolean isCorrect();

    /**
     * Set if the answer is chosen as the best one
     *
     * @param correct a new state for the answer
     */
    void setCorrect(boolean correct);

}
