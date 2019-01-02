package it.blackhat.symposium.actions.guest;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
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


public class SigninAction implements Action {
    private UserManager user;
    private Log signinLog = LogFactory.getLog(SigninAction.class);

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
            Optional<User> found = user.findUser(email, password);
            if (found.isPresent()) {
                HttpSession session = req.getSession();

                session.setAttribute("user", found);
                return "/index.jsp";
            } else {
                return "/error400.jsp";
            }
        } catch (SQLException e) {
            signinLog.error("problemi interni", e);
            return "/error500.jsp";
        }
    }
}
