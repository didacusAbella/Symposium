package it.blackhat.symposium.queries;

/**
 * This class contains all queries for the report
 *
 * @author SDelPiano
 */
public enum ReportQuery {
  
  TAKE_REPORT("SELECT id,category,reason,year,userFk FROM report WHERE questionFk=?"),
  INSERT_REPORT("INSERT INTO report (category,reason,year,questionFk,userFk) VALUES(?,?,?,?,?)"),
  UPDATE_QUESTION_REPORT("UPDATE question SET numReports=numReports+1 WHERE id=?"),
  GET_ALL_REPORTS("SELECT * from report"),
  GET_ALL_REPORTS_FOR_QUESTION("SELECT DISTINCT q.id, content, lastUpdate, creationDate, "
          + "numReports, q.userFk, title FROM question AS q, report AS r WHERE q.id=r.questionFk");
  
  private final String query;
  
  /**
   * 
   * @param query the SQL query 
   */
  private ReportQuery(String query) {
    this.query = query;
  }

  @Override
  public String toString() {
    return this.query;
  }
  
}
