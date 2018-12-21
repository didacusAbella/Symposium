package it.blackhat.symposium.queries;

public final class UserQuery {
	 /**
     * Crea un oggetto user query. Il costruttore è privato per non permettere
     * di instanziare l'oggetto
     */

    private UserQuery() {
    	/* hey*/
    	
    }
    	
    public static final String SIGN_UP = "INSERT INTO user VALUES( ? , ? , ? , ? , ? ,'', ?)";
    public static final String SIGN_IN = "SELECT * FROM user WHERE email= ? AND passoword= ?";
    public static final String EDIT_PROFILE = "UPDATE user SET username= ?, firstname= ?,"
    		+ " lastname= ?, password= ?, typegrad= ? WHERE email= ?";
    public static final String DELETE_ACCOUNT = "DELETE * FROM user WHERE email = ?";
   
    
    	
    	
    	
}



