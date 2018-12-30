package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Tag;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;


import static it.blackhat.symposium.queries.TagQuery.INSERT_TAG;

import static it.blackhat.symposium.queries.TagQuery.CHANGE_TAG;


/**
 * @author SDelPiano
 */

public class TagModelManager extends ConnectionManager implements TagManager {

   
    @Override
    public int insertTag(Question id, Tag tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int upd = run.update(INSERT_TAG, tag.getName());
        return upd;
    }

   

    @Override
    public int changeTag(Question id, Tag tag) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int upd = run.update(CHANGE_TAG, tag.getName());
        return upd;
    }

    


}