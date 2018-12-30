package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Tag;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

import static it.blackhat.symposium.queries.TagQuery.*;


/**
 * Describes the Tag Manager implementation
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
}
