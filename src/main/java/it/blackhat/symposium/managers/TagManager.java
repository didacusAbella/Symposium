package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Tag;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * This interface describe the methods of Tag Manager
 *
 * @author 2Deimos, SDelPiano
 */
public interface TagManager {

    /**
     * Insert a tag in a question
     *
     * @param tag tag data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int insertTag(Tag tag) throws SQLException;


    /**
     * Updates an older tag with a newer one in the tag's table
     *
     * @param tagName the content of the tag
     * @param questionId the Id of the question
     * @param tagId the id of the tag
     * @return the number of updated rows
     * @throws SQLException if the operation fails
     */
    int updateTag(String tagName, int questioId, int tagId) throws SQLException;


    /**
     * Delete a tag
     *
     * @param tagId the tag's id
     * @return the number of deleted rows
     * @throws SQLException if db error occured
     */
    int deleteTag(int tagId) throws SQLException;

    /**
     * Find a tag
     *
     * @param tagId the tag's id
     * @return the number of deleted rows
     * @throws SQLException if db error occured
     */
    int findTag(int tagId) throws SQLException;

    /**
     * Retrieves all tags related to a question
     *
     * @param questionId the questionId for retrieve the answers
     * @return a List of tags related to the question
     * @throws SQLException if db error occurred
     */
    List<Tag> retrieveQuestionTags(int questionId) throws SQLException;

    /**
     * Retrieve the most used tags of a year
     *
     * @param year year of the stats
     * @return a list of most used tags
     * @throws SQLException if db error occurred
     */
    Map<String, Integer> mostUsedTags(int year) throws SQLException;
}