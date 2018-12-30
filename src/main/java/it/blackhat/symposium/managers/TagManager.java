package it.blackhat.symposium.managers;

import java.sql.SQLException;




import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Tag;

/**
 *  This class describes the method signatures of Tag Manager
 * @author SDelPiano
 *
 */
public interface TagManager {
   
    /**
     * Insert a tag in a question
     *
     * @param question id data
     * @param tag      tag data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int insertTag(Question id, Tag tag) throws SQLException;

    
    /**
     * Change Tag in a question
     *
     * @param question id data
     * @param tag tag  data
     * @return the number of row updated
     * @throws SQLException if it encounter an error
     **/
    int changeTag(Question id, Tag tag) throws SQLException;




}




