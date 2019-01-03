package it.blackhat.symposium.actions.admin;

import it.blackhat.symposium.actions.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Signout Admin
 *
 * @author didacus
 */
public class SignoutAdmin implements Action {

    /**
     * Create a new Signout admin Action
     */
    public SignoutAdmin() {
        super();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        req.getSession().removeAttribute("admin");
        return "/index.jsp";
    }

}
