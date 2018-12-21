package it.blackhat.symposium.queries;

public final class AnswerQuery {
	/*vvv*/
	
    private AnswerQuery() {
		
   
    }
    public static final String INSERT_ANSWER = "INSERT INTO answer(content) VALUE (?)";
    public static final String DELETE_ANSWER = "DELETE FROM answer WHERE email = ?";
    
}
