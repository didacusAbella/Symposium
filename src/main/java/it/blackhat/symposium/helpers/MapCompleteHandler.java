package it.blackhat.symposium.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 *
 * @author Symposium Group
 */
public class MapCompleteHandler implements ResultSetHandler<Map<String, Integer>> {

    @Override
    public Map<String, Integer> handle(ResultSet rs) throws SQLException {
        Map<String, Integer> tagMap = new HashMap<>();
        while (rs.next()) {
            tagMap.put(rs.getString("name"), rs.getInt("uses"));
        }
        return tagMap;
    }

}
