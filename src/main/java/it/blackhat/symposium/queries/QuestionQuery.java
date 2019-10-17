package it.blackhat.symposium.queries;

/**
 * This class specifies queries about questions for the system.
 *
 * @author: SDelPiano
 * @author: GMadness97
 *
 */
public enum QuestionQuery {

  INSERT_QUESTION("INSERT INTO question(content,lastUpdate,creationDate,numReports,userFk,title) "
          + "VALUES(?,?,?,?,?,?)"),
  
  DELETE_QUESTION("DELETE FROM question WHERE id=?"),
  
  DELETE_QUESTION_TAG("DELETE FROM questiontag WHERE questionId=?"),
  
  RESEARCH_BY_WORDS("SELECT * FROM question WHERE content LIKE ?"),
  
  RESEARCH_BY_USER("SELECT * FROM question WHERE userFk=?"),
  
  RESEARCH_BY_TAG("SELECT question.id,content,lastUpdate,creationDate,numReports,userFk,title FROM "
          + "question,tag, questiontag WHERE question.id=questiontag.questionId AND tag.id="
          + "questiontag.tagId AND ? = tag.name"),
  
  LASTEDIT("SELECT * FROM question ORDER BY question.lastUpdate DESC"),
  
  FAVORITES("INSERT INTO favorites VALUES (?,?)"),
  
  SELECT_FAVORITE("SELECT question.id,content,lastUpdate,creationDate,numReports,userFk,title "
          + "FROM favorites, question  WHERE question.id=favorites.questionId "
          + "AND favorites.userId=?"),
  
  CHANGE_QUESTION_TAG("UPDATE questiontag SET tagId=? where tagid=? AND questionid=?"),
  
  TAKE_QUESTION("SELECT * FROM question WHERE id=?"),
  
  TAKE_ALL_QUESTIONS("SELECT * FROM question"),
  
  INSERT_QUESTION_TAG("INSERT INTO questiontag(questionId, tagId) VALUES(?, "
          + "(SELECT id FROM tag WHERE name=?))"),
  
  CONTROL_FAVORITES("SELECT f.userId FROM favorites AS f WHERE f.`userId`=? AND f.`questionId`=?");
  
  
  private final String query;
  
  /**
   * 
   * @param query The SQL query 
   */
  private QuestionQuery(String query) {
    this.query = query;
  }

  @Override
  public String toString() {
    return this.query;
  }
}
