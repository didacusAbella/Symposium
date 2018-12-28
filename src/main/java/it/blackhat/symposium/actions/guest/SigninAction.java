package it.blackhat.symposium.actions.guest;


import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
import it.blackhat.symposium.models.UserModel;


import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describes the guest's signin action
 * 
 * @author 2Deimos
 * 
 */
public class SigninAction implements Action {
/**
 * Find a user in the database and if it can't be found return with null
 * 
 */
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
    	Optional<User> user=null; //The 'findUser' methon can't be used with Optional<User>
    	String value=null;
    	String email=req.getParameter("email");
    	String password=req.getParameter("password");
    	try 
    	{
			  user=new UserModelManager().findUser(email, password);//it doesn't work since finduser uses the username and not the email
			 user.get();
		} 
    	catch (SQLException e) 
    	{
			return null;
		}
    	return value;//I don't know what the action is supposed to return
    }
}
