package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
import org.apache.commons.codec.digest.DigestUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Deletes the account of the user
 *
 * @author Parrilli Carminantonio
 */
public class DeleteAccountAction implements Action {
    private UserManager user;

    /**
     * Initialize an UserModelManager
     */
    public DeleteAccountAction() {
        super();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        user = new UserModelManager();
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
