package it.blackhat.symposium.managers;


import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.QuestionModel;
import it.blackhat.symposium.models.Tag;
import it.blackhat.symposium.models.TagModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static it.blackhat.symposium.queries.QuestionQuery.*;

/**
 * @author SDelPiano
 */

public class QuestionModelManager extends ConnectionManager implements QuestionManager {

    /**
     * Create a QuestionManager with a specified DataSource
     *
     * @param ds the DataSource
     */
    public QuestionModelManager(DataSource ds) {
        super(ds);
    }

    /**
     * Create a default QuestionManager
     */
    public QuestionModelManager() {
        super();
    }


    @Override
    public List<Question> seachQuestionsByTag(String tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        ResultSetHandler<List<Question>> h = new BeanListHandler<>(QuestionModel.class);
        List<Question> questions = run.query(RESEARCH_BY_TAG, h, tag);
        return questions;
    }


    @Override
    public List<Question> seachQuestionByWords(String words) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource); //bug in like query
        ResultSetHandler<List<Question>> h = new BeanListHandler<>(QuestionModel.class);
        List<Question> questions = run.query(RESEARCH_BY_WORDS, h, "%" + words + "%");
        return questions;
    }

    @Override
    public int insertQuestion(Question question) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        BigInteger update = run.insert(INSERT_QUESTION, new ScalarHandler<>(),
                question.getContent(), question.getLastUpdate(),
                question.getCreationDate(), question.getNumReports(),
                question.getUserFk(), question.getTitle());
        return update.intValue();
    }

    @Override
    public int insertQuestionTag(int questionId, String tagName) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(INSERT_QUESTION_TAG, questionId, tagName);
        return update;

    }

    @Override
    public int deleteQuestion(int questionId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(DELETE_QUESTION, questionId);
        return update;
    }

    @Override
    public int deleteQuestionTag(int questionId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(DELETE_QUESTION_TAG, questionId);
        return update;
    }

    @Override
    public int changeQuestionTag(Question question, Tag tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int upd = run.update(CHANGE_QUESTION_TAG, tag.getId(), question.getId());
        return upd;
    }

    @Override
    public int addFavourite(String userEmail, int questionId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        System.out.println(questionId);
        int upd = run.update(FAVORITES, userEmail, questionId);
        return upd;
    }

    @Override
    public List<Question> findFavorite(String userEmail) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        List<Question> questions = run.query(SELECT_FAVORITE,
                new BeanListHandler<>(QuestionModel.class), userEmail);
        return questions;
    }

    @Override
    public List<Question> showLastEdit() throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        List<Question> questions = run.query(LASTEDIT, new BeanListHandler<>(QuestionModel.class));
        return questions;
    }

    @Override
    public List<Question> showQuestionsByAuthor(String email) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        List<Question> questions = run.query(RESEARCH_BY_USER,
                new BeanListHandler<>(QuestionModel.class), email);
        return questions;
    }

    @Override
    public Optional<Question> findQuestion(int questionId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        Question question = run.query(TAKE_QUESTION,
                new BeanHandler<>(QuestionModel.class), questionId);
        return Optional.ofNullable(question);
    }
    
    @Override
    public boolean controlFavorite(String email,int idQuestion) throws SQLException{
        QueryRunner run = new QueryRunner(this.dataSource);
        List<Tag> tags = run.query(CONTROL_FAVORITES, new BeanListHandler<>(TagModel.class), email, idQuestion);
        return tags.isEmpty();
    }

}

