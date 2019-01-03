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
        super();
    }
    
    public static final String SIGN_IN = "SELECT * FROM admin "
            + "WHERE email=? AND password=?";
}
