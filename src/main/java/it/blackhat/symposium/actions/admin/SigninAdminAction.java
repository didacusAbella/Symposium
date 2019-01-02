package it.blackhat.symposium.actions.admin;

import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.AdminManager;
import it.blackhat.symposium.managers.AdminModelManager;
import it.blackhat.symposium.models.Admin;

/**
 * Describes the admin sign in action
 * 
 * @author didacus,Parrilli Carminantonio
 */
public class SigninAdminAction implements Action {

    private AdminManager admin;

    /**
     * Find a user in the database and if it can't be found return with null
     */
    public SigninAdminAction() {
        admin = new AdminModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            Optional<Admin> found = admin.findAdmin(email, password);
            if (found.isPresent()) {
                HttpSession session = req.getSession();

                session.setAttribute("admin", found);
                return "/index.jsp";
            } else {
                return "/error400.jsp";
            }
        } catch (SQLException e) {
            return "/error500.jsp";
        }
    }
}
