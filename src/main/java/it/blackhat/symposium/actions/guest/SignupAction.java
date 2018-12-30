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
            boolean flag;
            if (req.getParameter("typeGrad").equals("triennale")) {
                flag = false;
            } else {
                flag = true;
            }
           
            UserModel newUser = new UserModel();
            /*
             * 
             
            UserModel newUser = new UserModel(req.getParameter("username"), req.getParameter("firstName"),
                    req.getParameter("lastName"), req.getParameter("password")// Password too long for encription???
                    // java.sql.SQLException: Data truncation: Data too long for column 'password'
                    // at row 1 Query: INSERT INTO user (username, firstname, lastname, email,
                    // password, typegrad) VALUES( ? , ? , ? , ? , ? , ?) Parameters: [dsa, dsa,
                    // dsa, dsa@gmail.com,
                    // de04d58dc5ccc4b9671c3627fb8d626fe4a15810bc1fe3e724feea761965fb71, false]
                    , req.getParameter("email"), flag, null);
            
            System.out.print(newUser.getUsername());
            */
            BeanUtils.populate(newUser, req.getParameterMap());
            Optional<User> found = user.findUser(newUser.getEmail(), DigestUtils.sha256Hex(newUser.getPassword()));

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
            /*
             * } catch (IllegalAccessException e) {
             * signinLog.error("problemi interni IllegalAcces", e); return "/error500.jsp";
             * } catch (InvocationTargetException e) {
             * signinLog.error("problemi interni Target", e); return "/error500.jsp";
             */

        } catch (IllegalAccessException e) {
            signinLog.error("problemi interni Accesso", e);
            return "/error500.jsp";
        } catch (InvocationTargetException e) {
            signinLog.error("problemi interni Invocazione", e);
            return "/error500.jsp";
        }
    }
}
