package it.blackhat.symposium.queries;

/**
 * List of queries for Stats table
 * 
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
    public static final String GET_STATS = "SELECT * FROM stats WHERE year = ?";
    public static final String GET_NUM_USERS = "SELECT COUNT(*) AS total FROM user WHERE year = ?";
    public static final String GET_NUM_REPORTS = "SELECT COUNT(*) AS total "
            + "FROM report WHERE year = ?";
    public static final String CREATE_STATS = "INSERT INTO stats(numSigned, totalReports, year) "
            + "VALUES(?, ?, ?,) ";
    public static final String GET_BANNED_USERS = "SELECT COUNT(*) FROM user "
            + "WHERE YEAR(banLastDate) >= ?;";

}
