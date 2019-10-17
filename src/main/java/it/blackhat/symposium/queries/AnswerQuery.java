package it.blackhat.symposium.queries;

/**
 * This class contains all answer's queries
 *
 * @author SDelPiano
 */
public enum AnswerQuery {
  
  INSERT_ANSWER("INSERT INTO answer (content,userFk,questionFk,creationDate) VALUES (?,?,?,?)"),
  DELETE_ANSWER("DELETE FROM answer WHERE id=?"),
  BEST_ANSWER("UPDATE answer SET correct=1 WHERE id=?"),
  TAKE_ANSWERS("SELECT * FROM answer WHERE questionFk=?"),
  TAKE_ALL_ANSWERS("SELECT * FROM answer");
  
  private final String query;

  /**
   * 
   * @param query the SQL query
   */
  private AnswerQuery(String query) {
    this.query = query;
  }

  @Override
  public String toString() {
    return this.query;
  }
}
