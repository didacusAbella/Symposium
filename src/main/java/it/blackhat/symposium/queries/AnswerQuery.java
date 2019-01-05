package it.blackhat.symposium.queries;

/**
 * This class contains all answer's queries
 *
 * @author SDelPiano
 */
public final class AnswerQuery {

    /**
     * Create an empty answer query
     */
    private AnswerQuery() {
        super();
    }

    public static final String INSERT_ANSWER = "INSERT INTO answer "
            + "(content, userFk, questionFk,creationDate) VALUES (?, ?, ?, ?)";

    public static final String DELETE_ANSWER = "DELETE FROM answer "
            + "WHERE id = ?";

    public static final String BEST_ANSWER = "UPDATE answer SET correct=1 "
            + "WHERE id=?";

    public static final String TAKE_ANSWERS = "SELECT * FROM answer "
            + "WHERE questionFk = ?";
    public static final String TAKE_ALL_ANSWERS = "SELECT * FROM answer";
}