package it.blackhat.symposium.queries;

public final class TagQuery {
	
	/**
	 * This class specifies queries about tag for the questions for the system.
	 * @author: SDelPiano
	 **/
    private TagQuery() { 
    }
    public static final String CHANGE_TAG = "UPDATE tag SET name= ? WHERE question.id= ?";
    public static final String INSERT_TAG = "INSERT INTO contain(tagid) VALUE = ? "
    		+ "WHERE questionid = ? ";
}
















