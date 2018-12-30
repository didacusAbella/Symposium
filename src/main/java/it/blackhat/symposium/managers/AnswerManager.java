package it.blackhat.symposium.managers;

import java.sql.SQLException;

import it.blackhat.symposium.models.Answer;

/**
 *  This class describes the method signatures of Answer Manager
 * @author SDelPiano
 *
 */
public interface AnswerManager {
    /**
     * Insert an answer 
     *
     * @param answer answer data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int insertAnswer(Answer answer) throws SQLException;
    
    /**
     * Delete an answer
     *
     * @param answerId id of the answer
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int deleteAnswer(int answerId) throws SQLException;

   

}












