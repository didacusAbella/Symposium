package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Admin;
import it.blackhat.symposium.models.AdminModel;
import it.blackhat.symposium.models.Tag;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

import static it.blackhat.symposium.queries.AdminQuery.*;
import static it.blackhat.symposium.queries.TagQuery.INSERT_TAG;


/**
 *
 * @author Diego Avella
 */
public class TagModelManager extends ConnectionManager implements TagManager {


    @Override
    public Optional<Tag> insertTag(Tag tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        run.update(INSERT_TAG, tag.getId(), tag.getTagName());
        return Optional.empty();
    }

    @Override
    public int deleteTag(int tagId) throws SQLException {
        return 0;
    }
}
