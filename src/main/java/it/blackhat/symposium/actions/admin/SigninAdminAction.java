package it.blackhat.symposium.actions.admin;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.AdminManager;
import it.blackhat.symposium.managers.AdminModelManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author didacus
 */
public class SigninAdminAction implements Action {

    private final AdminManager adminManager = new AdminModelManager();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            req.setAttribute("admins", adminManager.findAllAdmins());
            return "/prova.jsp";
        } catch (SQLException ex) {
            Logger.getLogger(SigninAdminAction.class.getName()).log(Level.SEVERE, null, ex);
            return "/errore.jsp";
        }
    }

}
