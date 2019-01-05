package it.blackhat.symposium.actions.guest;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
import it.blackhat.symposium.models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Describes the guest's signup action
 * @author Parrilli Carminantonio
 * @author 2Deimos
 */

public class SignupAction implements Action {
    private UserManager user;
    private Log signUpLog = LogFactory.getLog(SigninAction.class);

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
            Optional<User> found = user.findEmail(newUser.getEmail());

            if (found.isPresent()) {
                req.setAttribute("emailErr", "Already Exist");
                return "/signUp.jsp";
            } else {
                newUser.setPassword(DigestUtils.sha256Hex(newUser.getPassword()));
                user.createUser(newUser);
                return "/signIn.jsp";
            }
        } catch (SQLException e) {
            signUpLog.error("problemi interni SQL", e);
            return "/error500.jsp";
        } catch (IllegalAccessException e) {
            signUpLog.error("problemi interni Accesso", e);
            return "/error500.jsp";
        } catch (InvocationTargetException e) {
            signUpLog.error("problemi interni Invocazione", e);
            return "/error500.jsp";
        }
    }
}
