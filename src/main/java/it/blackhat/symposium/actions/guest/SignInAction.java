package it.blackhat.symposium.actions.guest;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Describes the guest's signin action
 *
 * @author 2Deimos, Parrilli Carminantonio, SDelPiano
 */

public class SignInAction implements Action {
    private UserManager user;
    private Log signinLog = LogFactory.getLog(SignInAction.class);

    /**
     * Find a user in the database and if it can't be found return with null
     */
    public SignInAction() {
        user = new UserModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {

        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            Optional<User> found = user.findUser(email, DigestUtils.sha256Hex(password));
            if (found.isPresent()) {
                session.setAttribute("user", found);
                return "/index.jsp";
            } else {
                session.setAttribute("wrongCredentials", "Username o password sbagliati");
                return "/signIn.jsp";
            }
        } catch (SQLException e) {
            signinLog.error("problemi interni", e);
            return "/error500.jsp";
        }
    }
}
