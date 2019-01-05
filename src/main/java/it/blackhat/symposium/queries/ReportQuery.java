package it.blackhat.symposium.queries;

/**
 * This class contains all queries for the report
 *
 * @author SDelPiano
 */
public final class ReportQuery {

    public static final String TAKE_REPORT = "select id,category,reason,year,userFk FROM report " +
            "where questionFk=?";
    public static final String INSERT_REPORT = "insert into report(category,reason,year,questionFk,userFk) " +
            "values(?,?,?,?,?);update question set numReports=numReports+1 where id=?";

    private ReportQuery() {
        super();
    }

}