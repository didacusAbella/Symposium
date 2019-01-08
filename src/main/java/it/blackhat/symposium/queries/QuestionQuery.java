package it.blackhat.symposium.queries;

/**
 * This class specifies queries about questions for the system.
 *
 * @author: SDelPiano
 * @author: GMadness97
 **/
public final class QuestionQuery {


    /**
     * create an empty question query
     */
    private QuestionQuery() {
        super();
    }

    public static final String INSERT_QUESTION = "INSERT INTO"
            + " question(content,lastUpdate,creationDate,numReports,"
            + "userFk,title) VALUES(?,?,?,?,?,?)";

    public static final String DELETE_QUESTION = "DELETE FROM question WHERE id = ?";

    public static final String DELETE_QUESTION_TAG = "DELETE FROM questiontag WHERE questionId = ?";

    public static final String RESEARCH_BY_WORDS = "SELECT * FROM question"
            + " WHERE content LIKE '%?%'";
    public static final String RESEARCH_BY_USER = "SELECT * FROM question"
            + " WHERE userFk=?";

    public static final String RESEARCH_BY_TAG = "SELECT question.id ,content,"
            + "lastUpdate,creationDate,numReports,userFk,title"
            + " FROM question,tag, questiontag "
            + " WHERE question.id = questiontag.questionId "
            + "AND tag.id = questiontag.tagId AND ? = tag.name";

    public static final String LASTEDIT = "SELECT * FROM question"
            + " ORDER BY question.lastUpdate DESC";

    public static final String FAVORITES = "INSERT INTO favorites "
            + "VALUES (?, ?)";
  
    public static final String SELECT_FAVORITE = "SELECT question.id,content, "
            + "lastUpdate,creationDate,numReports,userFk,title  FROM favorites"
            + ", question  WHERE question.id= favorites.questionId AND "
            + "favorites.userId=?";

    public static final String CHANGE_QUESTION_TAG = "UPDATE questiontag SET tagId = ? "
            + "where tagid= ? AND questionid=?";

    public static final String TAKE_QUESTION = "SELECT * FROM question "
            + "WHERE id=?";

    public static final String TAKE_ALL_QUESTIONS = "SELECT * FROM question ";

    public static final String INSERT_QUESTION_TAG = "INSERT INTO questiontag(questionId,tagId) "
            + "VALUES(?,(SELECT id FROM tag WHERE name = ?))";


}
