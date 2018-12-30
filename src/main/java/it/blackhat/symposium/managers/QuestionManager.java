package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.User;
import java.sql.SQLException;
import java.util.Optional;

/**
*
* @author Del Piano Salvatore
*
*/

import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Tag;

public interface QuestionManager {
	/**
     * Insert a question 
     * @param question question data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int insertQuestion(Question question)throws SQLException; 
	/**
     * Insert a tag in a question
     * @param question question data
     * @param tag tag data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int insertTag(Question question, Tag tag) throws SQLException;
	/**
     * Delete a question 
     * @param question question data 
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int deleteQuestion(Question question) throws SQLException;
	/**
     *Change Tag in a question
     * @param question question
     * @param tag tag  data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int changeTag(Question question, Tag tag) throws SQLException;
	/**
     * Add a report to a question 
     * @param question question data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int questionReport(Question question) throws SQLException;
	
    
}
