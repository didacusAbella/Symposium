package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Answer;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;


import static it.blackhat.symposium.queries.AnswerQuery.INSERT_ANSWER;
import static it.blackhat.symposium.queries.AnswerQuery.DELETE_ANSWER;



/**
 * @author SDelPiano
 */

public class AnswerModelManager extends ConnectionManager implements AnswerManager {

    @Override
    public int insertAnswer(Answer answer) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(INSERT_ANSWER, answer.getContent());
        return update;
    }

   
    @Override
    public int deleteAnswer(int answerId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(DELETE_ANSWER, answerId);
        return update;
    }
}



