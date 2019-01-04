package it.blackhat.symposium.queries;

/**
 *
 * @author SDelPiano
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
            + "WHERE username=? AND password=?";
}
