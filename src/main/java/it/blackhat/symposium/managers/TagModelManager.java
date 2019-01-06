package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Tag;
import it.blackhat.symposium.models.TagModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
        int upd = run.update(INSERT_TAG, tag.getName(), tag.getName());
        return upd;
    }


    @Override
    public int updateTag(String tagName, int tagId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(CHANGE_TAG, tagName, tagId);
        return update;
    }


    @Override
    public int findTag(int tagId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(FIND_TAG, tagId);
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

    @Override
    public Map<String, Integer> mostUsedTags(int year) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        ResultSetHandler<Map<String, Integer>> a = new BeanMapHandler<String, Integer>
                (Integer.class, "name");
        Map<String, Integer> most = run.query(NUM_TAG, a, year);
        return most;

    }
}