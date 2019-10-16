package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Tag;

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
     *
   */
  int insertQuestion(Question question) throws SQLException;

  /**
   * Insert a question
   *
   * @param questionId id of the question
   * @param tagName id of the tag
   * @return the number of row updated
   * @throws SQLException if it encounter an error
     *
   */
  int insertQuestionTag(int questionId, String tagName) throws SQLException;

  /**
   * Delete a question
   *
   * @param questionId id of the question
   * @return the number of row updated
   * @throws SQLException if it encounter an error
     *
   */
  int deleteQuestion(int questionId) throws SQLException;

  /**
   * Delete a question
   *
   * @param questionId id of the question
   * @return the number of row updated
   * @throws SQLException if it encounter an error
     *
   */
  int deleteQuestionTag(int questionId) throws SQLException;

  /**
   * Change Tag in a question
   *
   * @param question question
   * @param tag tag data
   * @return the number of row updated
   * @throws SQLException if it encounter an error
     *
   */
  int changeQuestionTag(Question question, Tag tag) throws SQLException;

  /**
   * Change Tag in a question
   *
   * @param questionId question
   * @param userEmail email of the user
   * @return the number of row updated
   * @throws SQLException if db encounter an error
     *
   */
  int addFavourite(String userEmail, int questionId) throws SQLException;

  /**
   * Return the favorite questions of an user
   *
   * @param userEmail user e-mail
   * @return user favorite questions
   * @throws SQLException if db encounter an error
   */
  List<Question> findFavorite(String userEmail) throws SQLException;

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
   * @param email the email of the author
   * @return a List of all the questions founded
   * @throws SQLException if it encounter an error
   */
  List<Question> showQuestionsByAuthor(String email) throws SQLException;

  /**
   * Search all questions by tag
   *
   * @param tag the specific tag to search
   * @return a list of questions that have the tag
   * @throws SQLException if db encounter an error
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
   * Find if a Question is already a favorite of the user
   *
   * @param email user email
   * @param idQuestion if of the question
   * @return true if it is, false else
   * @throws SQLException if the db fail
   */
  boolean controlFavorite(String email, int idQuestion) throws SQLException;
}
