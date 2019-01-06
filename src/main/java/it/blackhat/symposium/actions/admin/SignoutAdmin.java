package it.blackhat.symposium.actions.admin;

import it.blackhat.symposium.actions.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Signout Admin
 *
 * @author Symposium Group
 */
public class SignoutAdmin implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        req.getSession().removeAttribute("admin");
        return "/index.jsp";
    }

}
