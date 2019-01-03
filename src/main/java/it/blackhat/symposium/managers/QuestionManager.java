package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Question;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * This class describes the method signatures of Question Manager
 *
 * @author SDelPiano
 * @author Gozzetto
 * @author GMadness97
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
     * Delete a question
     *
     * @param questionId id of the question
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int deleteQuestion(int questionId) throws SQLException;

    /**
     * Shows a list of question sorted by last edit
     *
     * @return List<Question> A list of questions
     * @throws SQLException if db encounter an error
     */
    List<Question> showLastEdit() throws SQLException;

    /**
     * Return the questions founded by the query
     *
     * @param tag tag used in the reseach
     * @return a List of all the questions founded
     * @throws SQLException if it encounter an error
     */
    List<Question> seachQuestionsByTag(String tag) throws SQLException;

    /**
     * Return the questions founded by the query
     *
     * @param words words used in the reseach
     * @return a List of all the questions founded
     * @throws SQLException it it encounter an error
     */
    List<Question> seachQuestionByWords(String words) throws SQLException;

    /**
     * Finds a Question object
     *
     * @param questionId the question id to find
     * @return an Optional<Question> object
     * @throws SQLException if it encounter an error
     */
    Optional<Question> findQuestion(int questionId) throws SQLException;

    /**
     * Finds a Question object
     *
     * @return an Optional<Question> object
     * @throws SQLException if it encounter an error
     */
    List<Question> retrieveAllQuestions() throws SQLException;
}












