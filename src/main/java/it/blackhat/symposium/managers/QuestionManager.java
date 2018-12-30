package it.blackhat.symposium.managers;

import java.sql.SQLException;
import java.util.List;


import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Tag;

/**
 *  This class describes the method signatures of Question Manager
 * @author SDelPiano
 *
 */
public interface QuestionManager {
    /**
     * Insert a question
     *
     * @param question question data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int insertQuestion(Question question) throws SQLException;

    /**
     * Insert a tag in a question
     *
     * @param question question data
     * @param tag      tag data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int insertTag(Question question, Tag tag) throws SQLException;

    /**
     * Delete a question
     *
     * @param questionId id of the question
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int deleteQuestion(int questionId) throws SQLException;

    /**
     * Change Tag in a question
     *
     * @param question question
     * @param tag      tag  data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int changeTag(Question question, Tag tag) throws SQLException;

    /**
     * Add a report to a question
     *
     * @param question question data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int questionReport(Question question) throws SQLException;

    /**
     * Shows a list of question sorted by last edit
     * @return List<Question> A list of questions
     * @throws SQLException if db encounter an error
     */
    List<Question> showLastEdit() throws SQLException;


}












