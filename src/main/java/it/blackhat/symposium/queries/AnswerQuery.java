package it.blackhat.symposium.queries;

public final class AnswerQuery {
	/**This class specifies queries about answers for the system.
	 * @author: SDelPiano
	 */
	
    private AnswerQuery() {
		
   
    }
    public static final String INSERT_ANSWER = "INSERT INTO answer(content) VALUE (?)";
    public static final String DELETE_ANSWER = "DELETE FROM answer WHERE email = ?";
    public static final String BEST_ANSWER = "UPDATE answer SET correct=1 WHERE id=?";
    public static final String TAKE_ANSWERS = "SELECT * FROM answer WHERE questionFk = ?";


}
