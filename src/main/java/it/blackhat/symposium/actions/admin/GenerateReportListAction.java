package it.blackhat.symposium.actions.admin;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

import it.blackhat.symposium.actions.Action;
/**
 * The class return a list of users for an admin
 * @author Parrilli Carminantonio
 * @author Przemyslaw Szopian
 */

public class GenerateReportListAction implements Action {
    private final ReportManager reportManager;
    private final Log showUserActionLog = LogFactory.getLog(GenerateReportListAction.class);;
    /**
     * The constructor of the class
     */
    public GenerateReportListAction() {
        reportManager = new ReportModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            List<Report> listReports = user.retrieveUsers();
            req.setAttribute("listUsers", listUsers);
            return "/userList.jsp";
        } catch (SQLException e) {
            showUserActionLog.error("Errore Interno SQL", e);
            return "/error400.jsp";
        }
    }

}
