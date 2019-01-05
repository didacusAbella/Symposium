package it.blackhat.symposium.actions.admin;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.ReportManager;
import it.blackhat.symposium.managers.ReportModelManager;
import it.blackhat.symposium.models.Report;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
            List<Report> listReports = reportManager.retrieveReport(0);
            req.setAttribute("listReports", listReports);
            return "/reportList.jsp";
        } catch (SQLException e) {
            showUserActionLog.error("Errore Interno SQL", e);
            return "/error500.jsp";
        }
    }

}
