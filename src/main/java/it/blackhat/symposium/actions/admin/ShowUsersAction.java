package it.blackhat.symposium.actions.admin;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
/**
 * The class return a list of users for an admin
 * @author Parrilli Carminantonio
 * @author Przemyslaw Szopian
 */

public class ShowUsersAction implements Action {
    private UserManager user;
    private final Log showUserActionLog = LogFactory.getLog(ShowUsersAction.class);;
    /**
     * The constructor of the class
     */
    public ShowUsersAction() {
        super();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            this.user = new UserModelManager();
            List<User> listUsers = user.retrieveUsers();
            req.setAttribute("listUsers", listUsers);
            return "/userList.jsp";
        } catch (SQLException e) {
            showUserActionLog.error("Errore Interno SQL", e);
            return "/error400.jsp";
        }
    }

}
