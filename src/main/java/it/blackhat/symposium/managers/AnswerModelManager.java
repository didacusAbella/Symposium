package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Answer;
import it.blackhat.symposium.models.AnswerModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

import static it.blackhat.symposium.queries.AnswerQuery.*;

/**
 * @author Gozzetto, SDelPiano
 */
public class AnswerModelManager extends ConnectionManager implements AnswerManager {


    @Override
    public int insertAnswer(Answer answer) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(INSERT_ANSWER, answer.getContent(),
                answer.getUserFk(), answer.getQuestionFk(),
                answer.getCreationDate());
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

    @Override
    public List<Answer> retrieveQuestionAnswers(int questionId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        ResultSetHandler<List<Answer>> h = new BeanListHandler<>(AnswerModel.class);
        List<Answer> answers = run.query(TAKE_ANSWERS, h, questionId);
        return answers;
    }

    @Override
    public List<Answer> retrieveAllQuestionAnswers() throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        ResultSetHandler<List<Answer>> j = new BeanListHandler<>(AnswerModel.class);
        List<Answer> answers = run.query(TAKE_ALL_ANSWERS, j);
        return answers;
    }
}