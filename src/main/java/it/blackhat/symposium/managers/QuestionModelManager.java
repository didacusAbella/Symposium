package it.blackhat.symposium.managers;


import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.QuestionModel;
import it.blackhat.symposium.models.Tag;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static it.blackhat.symposium.queries.QuestionQuery.*;
import static it.blackhat.symposium.queries.TagQuery.CHANGE_TAG;

/**
 * @author SDelPiano
 */

public class QuestionModelManager extends ConnectionManager implements QuestionManager {

    @SuppressWarnings("Duplicates")
    @Override
    public List<Question> seachQuestionsByTag(String tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        ResultSetHandler<List<Question>> h = new BeanListHandler<>(QuestionModel.class);
        List<Question> questions = run.query(RESEARCH_BY_TAG, h, tag);
        return questions;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public List<Question> seachQuestionByWords(String words) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        ResultSetHandler<List<Question>> h = new BeanListHandler<>(QuestionModel.class);
        List<Question> questions = run.query(RESEARCH_BY_TAG, h, words);
        return questions;
    }

    @Override
    public int insertQuestion(Question question) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(INSERT_QUESTION, question.getContent(), question.getLastUpdate(), question.getCreationDate(),
                question.getNumReports(), question.getUserFk(), question.getTitle());
        return update;
    }

    public int insertQuestionTag(Question question, Tag tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int upd = run.update(INSERT_QUESTION_TAG, tag.getId(), question.getId());
        return upd;
    }

    @Override
    public int deleteQuestion(int questionId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(DELETE_QUESTION, questionId);
        return update;
    }

    @Override
    public int changeQuestionTag(Question question, Tag tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int upd = run.update(CHANGE_TAG, tag.getId(), question.getId());
        return upd;
    }

    @Override
    public int addFavourite(String userEmail, int questionId ) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        System.out.println(questionId);
        int upd = run.update(FAVORITES, userEmail, questionId );
        return upd;
    }

    @Override
    public List<Question> showLastEdit() throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        List<Question> questions = run.query(LASTEDIT, new BeanListHandler<>(QuestionModel.class));
        return questions;
    }

    @Override
    public Optional<Question> findQuestion(int questionId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        Question question = run.query(TAKE_QUESTION,
                new BeanHandler<>(QuestionModel.class), questionId);
        return Optional.ofNullable(question);
    }

}

