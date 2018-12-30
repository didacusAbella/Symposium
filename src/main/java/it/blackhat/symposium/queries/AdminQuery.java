package it.blackhat.symposium.queries;

/**
 *
 * @author Diego Avella & Del Piano Salvatore
 */
public final class AdminQuery {

    /**
     * Create an admin query object. The constructor is private 
	 * to not allow the object to be instantiated.
     */
    private AdminQuery() {
    }

    
    public static final String SIGN_IN = "SELECT * FROM user WHERE email= ? AND password= ?";
    public static final String REPORT = "INSERT INTO report(year) VALUE(?)";
    public static final String BAN = "UPDATE user SET banlastdate= ?";
    
    
}
