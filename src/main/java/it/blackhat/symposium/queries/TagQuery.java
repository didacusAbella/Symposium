package it.blackhat.symposium.queries;

/**
 * This class specifies queries about tag for the questions for the system.
 *
 * @author: SDelPiano
 * @author: 2Deimos
 **/
public final class TagQuery {

    /**
     * Initialize a void TagQuery object
     */
    private TagQuery() {
        super();
    }
    
    public static final String INSERT_TAG = "INSERT INTO contain(tagId) VALUE = ? "
            + "WHERE questionId = ? ";
    public static final String CHANGE_TAG = "UPDATE Tag SET tagId = ?";
    public static final String CHANGE_QUESTION_TAG = "UPDATE questionTag SET "
            + "tagId = ? WHERE questionId= ?";
    public static final String DELETE_TAG = "DELETE FROM tag WHERE tagId = ? ";
    public static final String TAKE_TAGS = "select id, name from tag join questiontag on "
            + "questiontag.tagId = tag.id where questiontag.questionId = ?; ";

}
















