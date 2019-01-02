/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;


/**
 *
 * @author Przemyslaw Szopian
 */
public class EditProfileAction implements Action {
	private UserManager user;

	private Log editProfileLog = LogFactory.getLog(EditProfileAction.class);

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	
	public EditProfileAction(){
		user = new UserModelManager();
	}
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
	
		String email = req.getParameter("email");
        	String password = req.getParameter("password");
        	try {
            		Optional<User> found = user.findUser(email, password);
            		if (found.isPresent()) {
                	HttpSession session = req.getSession();

                	session.setAttribute("user", found);
                	return "/index.jsp";
            	} else {
                return "/error400.jsp";
            }
	 } catch (SQLException e) {
            editProfileLog.error("problemi interni", e);
            return "/error500.jsp";
        }
	} 
     
}