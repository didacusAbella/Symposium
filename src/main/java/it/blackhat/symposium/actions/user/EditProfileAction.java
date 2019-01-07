package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
import it.blackhat.symposium.models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Describes edit profile action!
 * @author Przemyslaw Szopian
 */
public class EditProfileAction implements Action {

    private UserManager user;

    private Log editProfileLog = LogFactory.getLog(EditProfileAction.class);

    /**
     * Initialize a new User Model Manager
     */
    public EditProfileAction() {
        user = new UserModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {

        try {
            User newUser = new UserModel();
            BeanUtils.populate(newUser, req.getParameterMap());
            boolean typeGrad = Boolean.parseBoolean(req.getParameter("typeGrad"));
            newUser.setTypeGrad(typeGrad);
            int upDate = user.editProfile(newUser);
            if (upDate == 1) {
                req.setAttribute("user", newUser);
                return "/profile.jsp";
            } else {
                return "/error400.jsp";
            }
        } catch (SQLException e) {
            editProfileLog.error("problemi interni", e);
            return "/error500.jsp";
        } catch (IllegalAccessException e) {
            editProfileLog.error("problemi interni Accesso", e);
            return "/error500.jsp";
        } catch (InvocationTargetException e) {
            editProfileLog.error("problemi interni Invocazione", e);
            return "/error500.jsp";
        }

    }
}
