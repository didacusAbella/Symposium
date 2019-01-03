/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
import java.sql.SQLException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/**
 *
 * @author Przemyslaw Szopian
 */
public class ShowProfileAction implements Action {

    private UserManager user;
    private Log showProfileLog = LogFactory.getLog(ShowProfileAction.class);

    /**
     * Initialize a new User Manager
     */
    public ShowProfileAction() {
        user = new UserModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {

        String email = req.getParameter("email");
        try {
            Optional<User> found = user.findEmail(email);
            if (found.isPresent()) {

                req.setAttribute("user", found.get());
                return "/profile.jsp";
            } else {
                return "/error400.jsp";
            }
        } catch (SQLException e) {
            showProfileLog.error("problemi interni", e);
            return "/error500.jsp";
        }
    }
}
