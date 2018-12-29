package it.blackhat.symposium.actions.guest;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
import java.sql.SQLException;
import java.util.Optional;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Describes the guest's signin action
 * 
 * @author 2Deimos, Parrilli Carminantonio
 * 
 * 
 */

@WebServlet("/SignIn")
public class SigninAction implements Action {
    private UserManager user;

    /**
     * Find a user in the database and if it can't be found return with null
     */
    public SigninAction() {
        user = new UserModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            Optional<User> found = user.findUser(email, DigestUtils.sha256Hex(password));
            if (found.isPresent()) {
                req.getSession(true);
                req.setAttribute("user", found);
                return "index.jsp";
            } else {
                return "error400.jsp";
            }
        } catch (SQLException e) {

            return "error500.jsp";
        }
    }
}
