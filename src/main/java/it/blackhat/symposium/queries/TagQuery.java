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

    public static final String INSERT_TAG = "INSERT INTO contain(tagid) VALUE = ? "
            + "WHERE questionid = ? ";
    public static final String CHANGE_TAG = "";
    public static final String CHANGE_QUESTION_TAG = "UPDATE questiontag SET "
            + "tagId= ? WHERE questionId= ?";
    public static final String DELETE_TAG = "";

}
















