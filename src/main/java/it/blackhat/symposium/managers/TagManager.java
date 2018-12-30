package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Admin;
import it.blackhat.symposium.models.Tag;

import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

/**
 * This interface describe the methods of Tag Manager
 * @author 2Deimos
 */
public interface TagManager {

    /**
     * Find an admin given username and password
     *
     * @param tag tag to insert
     * @return an instance of tag
     * @throws SQLException if db errors occurred
     */
    Optional<Tag> insertTag(Tag tag) throws SQLException;


    /**
     * Ban an user from the platform
     *
     * @param tagId the tag's id
     * @return the number of deleted rows
     * @throws SQLException if db error occured
     */
    int deleteTag(int tagId) throws SQLException;

}
