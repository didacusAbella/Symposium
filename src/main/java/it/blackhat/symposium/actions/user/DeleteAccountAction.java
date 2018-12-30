package it.blackhat.symposium.actions.user;

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
 * Deletes the account of the user if manages to find it
 * 
 * @author killer
 *
 */
@WebServlet("/DeleteAccount")
public class DeleteAccountAction implements Action {
    private UserManager user;

    /**
     * Find a user in the database and deletes it and if can't be found throws an
     * error
     */

    public DeleteAccountAction() {
        user = new UserModelManager();
    }

    public String execute(HttpServletRequest req, HttpServletResponse res) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            Optional<User> found = user.findUser(email, DigestUtils.sha256Hex(password));
            if (found.isPresent()) {
                req.getSession(false);
                user.deleteAccount((User) user);
                return "index.jsp";
            } else {
                return "error400.jsp";
            }
        } catch (SQLException e) {

            return "error500.jsp";
        }

    }
}
