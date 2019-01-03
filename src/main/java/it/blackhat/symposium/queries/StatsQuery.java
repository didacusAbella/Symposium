package it.blackhat.symposium.queries;

/**
 * List of queries for Stats table
 * @author killer
 *
 */
public final class StatsQuery {
    
    /**
     * Create an stats query object. The constructor is private to not allow the
     * object to be instantiated.
     */
    private StatsQuery() {
        super();
    }

    public static final String INCREASE_COUNT = "UPDATE stats SET numsigned = " 
         + "numsigned + 1 WHERE year= ?";
    public static final String GET_NUM_USERS = "SELECT COUNT(*) FROM user";

}
