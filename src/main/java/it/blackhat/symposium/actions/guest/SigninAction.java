package it.blackhat.symposium.actions.guest;


import it.blackhat.symposium.actions.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describes the guest's signin action
 * 
 * @author 2Deimos
 */
public class SigninAction implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
    	/*
    	 * 
    	 * 
    	 * method private boolean checkLogin()
    	 * {
    	 * 		String email=req.getElementById("email");
    	 * 		String password=req.getElementById("password");
    	 * 		Boolean check=checkIfNotAlreadtPresent(userName, password)
    	 * 		if(findUser(email,password)){return true;}	
    	 * 		else(return false;)
    	 * 		return false;
    	 * }
    	 * 
    	 * */
    	return "";
    }
}
