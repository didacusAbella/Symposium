package it.blackhat.symposium.queries;

/**
 * This class contains all answer's related queries
 * @author SDelPiano
 */
public final class AnswerQuery {
    
	/**
     * Create a new AnswerQuery Wrapper
	 * @author: SDelPiano
	 */
    private AnswerQuery() {
        super();
    }
    
    public static final String INSERT_ANSWER = "INSERT INTO answer "
            + "(content, userFk, questionFk) VALUES (?, ?, ?)";
    
    public static final String DELETE_ANSWER = "DELETE FROM answer "
            + "WHERE email = ?";
    
    public static final String BEST_ANSWER = "UPDATE answer SET correct=1 "
            + "WHERE id=?";
    
    public static final String TAKE_ANSWERS = "SELECT * FROM answer "
            + "WHERE questionFk = ?";
}
