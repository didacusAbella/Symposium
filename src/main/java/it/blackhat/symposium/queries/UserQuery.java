package it.blackhat.symposium.queries;

public final class UserQuery {
	 /**
	  * Create an user query object. The constructor is private 
	  * to not allow the object to be instantiated.
      * @author: SDelPiano

      */

    private UserQuery() {
    	
    }
    	
    public static final String SIGN_UP = "INSERT INTO user (username, firstname, "
    		+ "lastname, email, password, typegrad) VALUES( ? , ? , ? , ? , ? , ?)";
    public static final String SIGN_IN = "SELECT * FROM user WHERE email= ? AND password= ?";
    public static final String EDIT_PROFILE = "UPDATE user SET username= ?, firstname= ?,"
    		+ " lastname= ?, password= ?, typegrad= ? WHERE email= ?";
    public static final String DELETE_ACCOUNT = "DELETE * FROM user WHERE email = ?";
    public static final String FIND_EMAIL = "SELECT * FROM user WHERE user.email=?";
   
    
    	
    	
    	
}



