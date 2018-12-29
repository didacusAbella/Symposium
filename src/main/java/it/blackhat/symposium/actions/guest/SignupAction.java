package it.blackhat.symposium.actions.guest;


import it.blackhat.symposium.actions.Action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describes the guest's signup action
 * 
 * @author 2Deimos
 */
@WebServlet("/SignUp")
public class SignupAction implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
    	return "index.jsp";
    }
}
