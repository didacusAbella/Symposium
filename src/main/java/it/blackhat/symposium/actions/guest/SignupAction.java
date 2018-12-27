package it.blackhat.symposium.actions.guest;


import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.models.User;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describes the guest's signup action
 * 
 * @author 2Deimos
 */
public class SignUpAction implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) 
    {
    	/*
    	 * method private boolean checkIfNotAlreadtPresent throws SQLException(req)
    	 * {
    	 * 		alreadyPresent=true;
    	 * 		String userName=req.getElementById("userName");
    	 * 		String password=req.getElementById("password");
    	 * 		try
    	 * 		{
    	 * 			if(findUser(userName,password)==null) {alreadyPresent=false;}
    	 * 			else{alreadyPresent=true}
    	 * 		}
    	 * 		catch(Execption e){}
    	 * 		
    	 *		return alreadyPresent;
    	 *private boolean alreadyPresent;
    	 * }
    	 * 
    	 * method private boolean addUser()
    	 * {
    	 * 		String userName=req.getElementById("userName");
    	 * 		String password=req.getElementById("password");
    	 * 		String email=req.getElementById("password");
    	 * 		Boolean check=checkIfNotAlreadtPresent(userName, password)
    	 * 		if(!check){UserModel newUser= new UserModel(userName,password,email) throws SQLException;}	
    	 * 		else(return false;)
    	 * 		return true;
    	 * }
    	 * 
    	 * */
    	return "index.jsp";
    }
}
