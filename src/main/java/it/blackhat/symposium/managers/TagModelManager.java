package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Tag;
import it.blackhat.symposium.models.TagModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

import static it.blackhat.symposium.queries.TagQuery.*;


/**
 * Describes the Tag Manager implementation
 *
 * @author 2Deimos
 */
public class TagModelManager extends ConnectionManager implements TagManager {


    @Override
    public int insertTag(Tag tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(INSERT_TAG, tag.getId(), tag.getName());
        return update;
    }

    @Override
    public int updateTag(Tag tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(CHANGE_TAG, tag.getName(), tag.getId());
        return update;
    }

    @Override
    public int changeQuestionTag(int tagId, int questionId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(CHANGE_QUESTION_TAG, tagId, questionId);
        return update;
    }

    @Override
    public int deleteTag(int tagId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(DELETE_TAG, tagId);
        return update;
    }

    @Override
    public List<Tag> retrieveQuestionTags(int questionId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        ResultSetHandler<List<Tag>> h = new BeanListHandler<>(TagModel.class);
        List<Tag> tags = run.query(TAKE_TAGS, h, questionId);
        return tags;
    }
}
