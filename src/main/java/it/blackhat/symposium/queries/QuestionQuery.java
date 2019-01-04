package it.blackhat.symposium.queries;

/**
 * Class that contains all query for the question table
 * @author GMadness97
 */
public final class QuestionQuery {
	/**
	 * This class specifies queries about questions for the system.
	 * @author: SDelPiano
   * @author: GMadness97
	 **/
    private QuestionQuery() { 
        super();
    }

    public static final String INSERT_QUESTION = "insert into question(content,lastUpdate,creationDate,numReports," +
            "userFk,title) values(?,?,?,?,?,?)";
   
    public static final String DELETE_QUESTION = "DELETE FROM question "
            + "WHERE id = ?";
    
    public static final String RESEARCH_BY_WORDS = "SELECT * FROM question"
    		+ " WHERE content LIKE '%?%'";
    
    public static final String RESEARCH_BY_TAG = "SELECT question.id ,content,"
            + "lastUpdate,creationDate,numReports,userFk,title"  
    		+ " FROM question,tag, questiontag " 
    		+ " WHERE question.id = questiontag.questionId "
            + "AND tag.id = questiontag.tagId AND ? = tag.name";
    
    public static final String FAVORITES = "INSERT INTO favorites "
            + "VALUES (?, ?)";
    
    public static final String LASTEDIT = "SELECT content FROM question" 
    		+ " ORDER BY lastmod DESC";
    
    public static final String TAKE_QUESTION = "SELECT * FROM question "
            + "WHERE id=?";
    public static final String TAKE_ALL_QUESTIONS = "SELECT * FROM question ";

    public static final String CHANGE_QUESTION_TAG = "UPDATE questiontag SET tagId = ? " +
            "where tagid= ? AND questionid=?";

    public static final String INSERT_QUESTION_TAG = "INSERT INTO questiontag() VALUE (?,?)";
}
