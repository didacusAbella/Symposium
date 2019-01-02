package it.blackhat.symposium.actions.guest;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
import it.blackhat.symposium.models.UserModel;

/**
 * @author killer, 2Deimos Describes the guest's signup action
 *
 */

public class SignUpAction implements Action {
    private UserManager user;
    private Log signupLog = LogFactory.getLog(SignInAction.class);

    /**
     * Add another user in the database if not present
     */
    public SignUpAction() {
        user = new UserModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {

        try {

            UserModel newUser = new UserModel();
            BeanUtils.populate(newUser, req.getParameterMap());
            Optional<User> found = user.findEmail(newUser.getEmail());

            if (found.isPresent()) {
                req.setAttribute("emailAlreadyExists", "L'email è gia in uso");
                return "/signUp.jsp";
            } else {
                newUser.setPassword(DigestUtils.sha256Hex(req.getParameter("password")));
                user.createUser(newUser);
                req.getSession(true);
                req.setAttribute("user", found);
                return "/index.jsp";
            }
        } catch (SQLException e) {
            signupLog.error("problemi interni SQL", e);
            return "/error500.jsp";
        } catch (IllegalAccessException e) {
            signupLog.error("problemi interni Accesso", e);
            return "/error500.jsp";
        } catch (InvocationTargetException e) {
            signupLog.error("problemi interni Invocazione", e);
            return "/error500.jsp";
        }
    }
}
