package it.blackhat.symposium.queries;

public final class QuestionQuery {
    public static final String DELETE_QUESTION = "DELETE FROM question WHERE id = ?";

    public static final String INSERT_QUESTION = "INSERT INTO question(content, title)" 
			+ " VALUES(? , ?)";
    public static final String QUESTION_REPORT = "UPDATE question SET numReports = numReports+1"
            + " WHERE id=?";
    public static final String RESEARCH_BY_WORDS = "SELECT * FROM question"
    		+ " WHERE content LIKE '%?%'";
    public static final String RESEARCH_BY_TAG = "SELECT content\r\n"
            + "FROM question,tag, contains"
    		+ "WHERE question.id=contains.questionId && tag.id=contains.tagId && ?= tag.nome";
    public static final String LASTEDIT = "SELECT content FROM question\r\n"
            + " ORDER BY lastmod DESC";
    public static final String FAVORITES = "INSERT INTO favorites VALUES ( ?, ?)";
    public static final String TAKE__ALL_QUESTIONS = "SELECT * FROM question";
    public static final String TAKE_QUESTION = "SELECT * FROM question WHERE id=?";

    /**
     * This class specifies queries about questions for the system.
     *
     * @author: SDelPiano
     * @author: GMadness97
     **/
    private QuestionQuery() {

    }

}






