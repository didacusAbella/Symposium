package it.blackhat.symposium.queries;

/**
 * This class contains all queries for user table
 *
 * @author didacus
 */
public final class UserQuery {

    public static final String FIND_EMAIL = "SELECT * FROM user "
            + "WHERE email=?";

    public static final String SIGN_UP = "INSERT INTO user (username, "
            + "firstName, lastName, email, password, typeGrad) "
            + "VALUES( ? , ? , ? , ? , ? , ?)";

    public static final String SIGN_IN = "SELECT * FROM user WHERE email=? "
            + "AND password=?";

    public static final String EDIT_PROFILE = "UPDATE user SET username=?, "
            + "firstName=?, lastName=?, password=?, typeGrad=? WHERE email=?";

    public static final String DELETE_ACCOUNT = "DELETE * FROM user "
            + "WHERE email=?";
    public static final String TAKE_ALL_USERS = "SELECT * FROM user";

    public static final String BAN = "UPDATE user SET banLastDate=? where email=?";

    /**
     * Create an user query object. The constructor is private
     * to not allow the object to be instantiated.
     *
     * @author: SDelPiano
     */
    private UserQuery() {
        super();
    }
}

