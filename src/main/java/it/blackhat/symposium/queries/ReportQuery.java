package it.blackhat.symposium.queries;

/**
 * This class contains all queries for the report
 *
 * @author SDelPiano
 */
public final class ReportQuery {

    /**
     * Create an empty report query
     */
    private ReportQuery() {
        super();
    }

    public static final String TAKE_REPORT = "SELECT id,category,reason,year,userFk FROM report "
            + "WHERE questionFk=?";

    public static final String INSERT_REPORT = "INSERT INTO"
            + " report(category,reason,year,questionFk,userFk)"
            + "VALUES(?,?,?,?,?); UPDATE question SET numReports=numReports+1 WHERE id=?";



}