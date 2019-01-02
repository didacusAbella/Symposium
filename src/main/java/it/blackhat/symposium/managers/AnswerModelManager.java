package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Answer;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

import static it.blackhat.symposium.queries.AnswerQuery.*;

/**
 * @author Angelo Maffettone
 */
public class AnswerModelManager extends ConnectionManager implements AnswerManager  {


    @Override
    public int insertAnswer(Answer answer) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(INSERT_ANSWER, answer.getContent());
        return update;
    }

    @Override
    public int removeAnswer(int id) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(DELETE_ANSWER, id);
        return update;
    }

    @Override
    public int bestAnswer(int id) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(BEST_ANSWER, id);
        return update;
    }
}
