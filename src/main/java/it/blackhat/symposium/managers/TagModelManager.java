package it.blackhat.symposium.managers;

import it.blackhat.symposium.helpers.MapCompleteHandler;
import it.blackhat.symposium.models.Tag;
import it.blackhat.symposium.models.TagModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static it.blackhat.symposium.queries.TagQuery.*;


/**
 * Describes the Tag Manager implementation
 *
 * @author 2Deimos
 */
public class TagModelManager extends ConnectionManager implements TagManager {

    /**
     * Create a TagManager with a specified DataSource
     * @param ds the data source
     */
    public TagModelManager(DataSource ds) {
        super(ds);
    }

    /**
     * Create a default TagManager
     */
    public TagModelManager() {
        super();
    }

    @Override
    public int insertTag(Tag tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        String constValue = String.format("\'%s\'", tag.getName());
        int upd = run.update(INSERT_TAG, constValue, tag.getName());
        return upd;
    }


    @Override
    public int updateTag(String tagName, int questionId, int tagId) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(CHANGE_SINGLE_TAG, tagName, questionId, tagId);
        return update;
    }


    @Override
    public Optional<Tag> findTag(String tagName) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        Tag found = run.query(FIND_TAG, new BeanHandler<>(TagModel.class), tagName);
        return Optional.ofNullable(found);
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
        Map<String, Integer> most = run.query(NUM_TAG, new MapCompleteHandler(), year);

        return most;

    }
}