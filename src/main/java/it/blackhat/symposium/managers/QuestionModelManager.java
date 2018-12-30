package it.blackhat.symposium.managers;


import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.QuestionModel;
import it.blackhat.symposium.models.Tag;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import static it.blackhat.symposium.queries.QuestionQuery.*;
import static it.blackhat.symposium.queries.TagQuery.INSERT_TAG;
import static it.blackhat.symposium.queries.TagQuery.CHANGE_TAG;


/**
 * @author SDelPiano
 */

public class QuestionModelManager extends ConnectionManager implements QuestionManager {

    @Override
    public int insertQuestion(Question question) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(INSERT_QUESTION, question.getContent());
        return update;
    }

    @Override
    public int insertTag(Question question, Tag tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int upd = run.update(INSERT_TAG, tag.getTagName());
        return upd;
    }

    @Override
    public int deleteQuestion(int questionId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(DELETE_QUESTION, questionId);
        return update;
    }

    @Override
    public int changeTag(Question question, Tag tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int upd = run.update(CHANGE_TAG, tag.getTagName());
        return upd;
    }

    @Override
	public int questionReport(Question question) throws SQLException {
    	QueryRunner run = new QueryRunner(this.dataSource);
    	int upd = run.update(QUESTION_REPORT , question.getNumReports());
    	return upd;
    }

    @Override
    public List<Question> showLastEdit() throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        List<Question> questions = run.query(LASTEDIT, new BeanListHandler<>(QuestionModel.class));
        return questions;
    }


}

