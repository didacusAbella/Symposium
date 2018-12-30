package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Answer;

import java.sql.SQLException;


/**
 *  This class describes the method signatures of Answer Manager
 * @author Angelo Maffettone
 *
 */
public interface AnswerManager {

    /**
     *  Insert an Answer given an Answer object
     * @param answer Answer to insert
     * @return true if the operation go well, false otherwise
     * @throws SQLException if db errors occurred
     */
    public int insertAnswer (Answer answer) throws SQLException;

    /**
     *  Remove an Answer given a id
     * @param id AnswerId to remove
     * @return true if the operation go well, false otherwise
     * @throws SQLException if db errors occurred
     */
    public int removeAnswer (int id) throws SQLException;

    /**
     *  Insert an Answer given a id
     * @param id Answer id to remove
     * @return true if the operation go well, false otherwise
     * @throws SQLException if db errors occurred
     */
    public int bestAnswer (int id) throws SQLException;

}
