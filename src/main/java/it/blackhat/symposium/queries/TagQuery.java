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

    public static final String INSERT_TAG = "INSERT INTO questiontag() VALUE (?,?) ";
    public static final String CHANGE_TAG = "UPDATE tag SET name = ? where id=?";
    public static final String CHANGE_QUESTION_TAG = "UPDATE questiontag SET tagId = ? where tagid= ? AND questionid=?";
    public static final String DELETE_TAG = "DELETE FROM tag WHERE id = ? ";
    public static final String TAKE_TAGS = "select id, name from tag join questiontag on questiontag.tagId = tag.id" +
            " where  questiontag.questionId = ?; ";
    public static final String FIND_TAG = "SELECT id, name  WHERE name = ? ";



}
















