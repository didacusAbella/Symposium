package it.blackhat.symposium.actions.user.guest;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.AdminManager;
import it.blackhat.symposium.managers.AdminModelManager;
import it.blackhat.symposium.models.Admin;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describes the admin sign in action
 *
 * @author didacus,Parrilli Carminantonio
 */
public class SigninAdminAction implements Action {

    private final AdminManager admin;

    /**
     * Find a user in the database and if it can't be found return with null
     */
    public SigninAdminAction() {
        admin = new AdminModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            Optional<Admin> found = admin.findAdmin(username, password);
            if (found.isPresent()) {
                HttpSession session = req.getSession(true);
                session.setAttribute("admin", found.get());
                return "/index.jsp";
            } else {
                req.setAttribute("errLogAdmin", "Credenziali Errate");
                return "/adminSignIn.jsp";
            }
        } catch (SQLException e) {
            return "/error500.jsp";
        }
    }
}
