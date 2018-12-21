package it.blackhat.symposium.queries;


public final class QuestionQuery {
	/**
	 * This class specifies queries about questions for the system.
	 * @author: SDelPiano
	 **/
    private QuestionQuery() { 
    
    	
    }

    public static final String INSERT_QUESTION = "INSERT INTO question(content)" 
			+ " VALUES(?)";
    public static final String DELETE_QUESTION = "DELETE FROM question WHERE email = ?";
    public static final String CHANGE_TAG = "UPDATE tag SET name= ? WHERE question.id= ?";
    public static final String QUESTION_REPORT = "UPDATE question SET numreports = numreports+1";

}
