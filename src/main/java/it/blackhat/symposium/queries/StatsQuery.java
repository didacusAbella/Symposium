package it.blackhat.symposium.queries;


public enum StatsQuery {
  
  GET_STATS("SELECT * FROM stats WHERE year=?"),
  
  GET_NUM_USERS("SELECT COUNT(*) AS total FROM user WHERE year=?"),
  
  GET_NUM_REPORTS("SELECT COUNT(*) AS total FROM report WHERE year=?"),
  
  CREATE_STATS("INSERT INTO stats (numSigned,totalReports,year) VALUES(?,?,?)"),
  
  GET_BANNED_USERS("SELECT COUNT(*) FROM user WHERE YEAR(banLastDate) >= ?"),
  
  UPDATE_STATSTAG("INSERT INTO statstag(uses,statsId,tagId) VALUES((uses+1), (SELECT id FROM stats "
          + "WHERE year = ?), (SELECT id FROM tag WHERE name = ? LIMIT 1)) ON DUPLICATE KEY "
          + "UPDATE uses = uses+1");
  
  private final String query;

  /**
   * 
   * @param query the SQL query 
   */
  private StatsQuery(String query) {
    this.query = query;
  }

  @Override
  public String toString() {
    return this.query;
  }

}
