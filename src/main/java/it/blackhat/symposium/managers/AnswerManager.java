package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Answer;

import java.sql.SQLException;
import java.util.List;


/**
 * This class describes the method signatures of Answer Manager
 *
 * @author Gozzetto
 */
public interface AnswerManager {

    /**
     * Insert an Answer given an Answer object
     *
     * @param answer Answer to insert
     * @return true if the operation go well, false otherwise
     * @throws SQLException if db errors occurred
     */
    int insertAnswer(Answer answer) throws SQLException;

    /**
     * Remove an Answer given a id
     *
     * @param id AnswerId to remove
     * @return true if the operation go well, false otherwise
     * @throws SQLException if db errors occurred
     */
    int removeAnswer(int id) throws SQLException;

    /**
     * Insert an Answer given a id
     *
     * @param id Answer id to remove
     * @return true if the operation go well, false otherwise
     * @throws SQLException if db errors occurred
     */
    int bestAnswer(int id) throws SQLException;

    /**
     * Retrieves all answers related to a question
     *
     * @param questionId the questionId for retrieve the answers
     * @return a List of tags related to the question
     * @throws SQLException if db error occurred
     */
    List<Answer> retrieveQuestionAnswers(int questionId) throws SQLException;
}
