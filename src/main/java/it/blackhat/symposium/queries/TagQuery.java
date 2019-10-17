package it.blackhat.symposium.queries;

public enum TagQuery {
  
  INSERT_TAG("INSERT INTO tag (name) SELECT * FROM (SELECT ?) AS tmp WHERE NOT EXISTS "
          + "(SELECT name FROM tag WHERE name = ? limit 1)"),
  
  CHANGE_TAG("UPDATE tag SET name = ? where id=?"),
  
  DELETE_TAG("DELETE FROM tag WHERE id = ?"),
  
  TAKE_TAGS("SELECT id, name FROM tag JOIN questiontag ON questiontag.tagId = tag.id "
          + "WHERE questiontag.questionId = ?"),
  
  FIND_TAG("SELECT id,name FROM tag WHERE name = ?"),
  
  NUM_TAG("SELECT name, uses FROM tag JOIN statstag WHERE(id=tagId AND statsId= (SELECT id FROM "
          + "stats WHERE year = ? LIMIT 1))"),
  
  CHANGE_SINGLE_TAG("UPDATE questiontag AS qt SET qt.`tagId` = (SELECT id as idT FROM tag WHERE "
          + "name=?) WHERE qt.`questionId`= ?  AND qt.`tagId` = ?");
  
  
  private final String query;

  /**
   * 
   * @param query the SQL query
   */
  private TagQuery(String query) {
    this.query = query;
  }

  @Override
  public String toString() {
    return this.query;
  }

  
}
