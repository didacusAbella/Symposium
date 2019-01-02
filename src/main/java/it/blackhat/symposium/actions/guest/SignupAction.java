package it.blackhat.symposium.actions.guest;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
import it.blackhat.symposium.models.UserModel;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author killer, 2Deimos Describes the guest's signup action
 *
 */

public class SignupAction implements Action {
    private UserManager user;
    private Log signinLog = LogFactory.getLog(SigninAction.class);

    /**
     * Add another user in the database if not present
     */
    public SignupAction() {
        user = new UserModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {

        try {

            UserModel newUser = new UserModel();
            BeanUtils.populate(newUser, req.getParameterMap());
            Optional<User> found = user.findUser(newUser.getEmail(), 
                    DigestUtils.sha256Hex(newUser.getPassword()));

            if (found.isPresent()) {
                req.setAttribute("email", "Already Exist");
                return "/signUp.jsp";
            } else {
                user.createUser(newUser);
                req.getSession(true);
                req.setAttribute("user", found);
                return "/index.jsp";
            }
        } catch (SQLException e) {
            signinLog.error("problemi interni SQL", e);
            return "/error500.jsp";
        } catch (IllegalAccessException e) {
            signinLog.error("problemi interni Accesso", e);
            return "/error500.jsp";
        } catch (InvocationTargetException e) {
            signinLog.error("problemi interni Invocazione", e);
            return "/error500.jsp";
        }
    }
}
