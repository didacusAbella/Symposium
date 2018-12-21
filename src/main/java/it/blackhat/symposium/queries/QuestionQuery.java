package it.blackhat.symposium.queries;

public final class QuestionQuery {

    private QuestionQuery() { 
    	
    }

    public static final String INSERT_QUESTION = "INSERT INTO question(content,tag.id)" 
			+ " VALUES(?,?)";
    public static final String DELETE_QUESTION = "DELETE FROM question WHERE email = ?";
    public static final String CHANGE_TAG = "UPDATE tag SET name= ? WHERE question.id= ?";
    public static final String QUESTION_REPORT = "UPDATE question SET numreports = numreports+1";

}
