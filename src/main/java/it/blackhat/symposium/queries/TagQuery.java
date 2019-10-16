package it.blackhat.symposium.queries;

/**
 * This class specifies queries about tag for the questions for the system.
 *
 * @author: SDelPiano
 * @author: 2Deimos
 *
 */
public final class TagQuery {

  /**
   * Initialize a void TagQuery object
   */
  private TagQuery() {
    super();
  }

  public static final String INSERT_TAG = "INSERT INTO tag (name) SELECT * FROM (SELECT ?) "
          + "AS tmp WHERE NOT EXISTS "
          + "(SELECT name FROM tag WHERE name = ? limit 1)";

  public static final String CHANGE_TAG = "UPDATE tag SET name = ? where id=?";

  public static final String DELETE_TAG = "DELETE FROM tag WHERE id = ?";

  public static final String TAKE_TAGS = "SELECT id, name FROM tag "
          + "JOIN questiontag ON questiontag.tagId = tag.id "
          + "WHERE questiontag.questionId = ?; ";

  public static final String FIND_TAG = "SELECT id,name FROM tag WHERE name = ?";

  public static final String NUM_TAG = "SELECT name, uses FROM tag JOIN statstag WHERE("
          + " id=tagId AND statsId=(SELECT id"
          + " FROM stats WHERE year = ? LIMIT 1))";

  public static final String CHANGE_SINGLE_TAG = "UPDATE questiontag AS qt "
          + "SET qt.`tagId` = (SELECT id as idT FROM tag WHERE name= ? ) "
          + "WHERE qt.`questionId`= ?  AND qt.`tagId` = ?";
}
