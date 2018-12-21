package it.blackhat.symposium.queries;

/**
 *
 * @author Diego Avella
 */
public final class AdminQuery {

    /**
     * Create an admin query object. The constructor is private 
	 * to not allow the object to be instantiated.
     */
    private AdminQuery() {
    }

    public static final String FIND_ADMIN = "SELECT * FROM admin WHERE username=? AND password=?";
    public static final String ADD_ADMIN = "INSERT INTO Admin (username, password) VALUES (?, ?)";
    public static final String UPDATE_ADMIN = "UPDATE Admin SET password=? WHERE username=?";
    public static final String DELETE_ADMIN = "DELETE FROM Admin WHERE username=?";
    public static final String ALL_ADMINS = "SELECT * FROM admin";
    public static final String SIGN_IN = "SELECT * FROM user WHERE email= ? AND passoword= ?";
    public static final String REPORT = "INSERT INTO report(year) VALUE(?)";
    public static final String BAN = "UPDATE user SET banlastdate= ?";
    
    
}
