package it.blackhat.symposium.actions.admin;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.AdminModelManager;

/**
 * 
 * @author Parrilli Carminantonio
 * 
 *         Describes the report action for the admin
 */
public class ReportAction implements Action {
    private AdminModelManager adminManager;

    /**
     * The constructor of the class
     */
    public ReportAction() {
        adminManager = new AdminModelManager();
    }

    /**
     * 
     * @param req the request from the JSP
     * @param res the response for the JSP
     * @return String the redirect page
     */
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            adminManager.genReport(req.getParameter("year"));
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
}
