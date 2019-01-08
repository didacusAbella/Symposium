package it.blackhat.symposium.actions.admin;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.managers.ReportManager;
import it.blackhat.symposium.managers.ReportModelManager;
import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Report;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The class return a list of users for an admin
 *
 * @author Parrilli Carminantonio
 * @author Przemyslaw Szopian
 */

public class GenerateReportListAction implements Action {

    private ReportManager reportManager;
    private QuestionManager questionManager;

    private final Log generateReportListActionLog = 
            LogFactory.getLog(GenerateReportListAction.class);

    ;
    /**
     * The constructor of the class
     */
    public GenerateReportListAction() {
        
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        this.reportManager = new ReportModelManager();
        this.questionManager = new QuestionModelManager();
        try {
            List<Report> listReports = reportManager.retrieveAllReports();
            List<Question> listQuestions = new ArrayList<>();

            for (Report r : listReports) {
                Optional<Question> found = questionManager.findQuestion(r.getQuestionFk());
                listQuestions.add(found.get());
            }

            req.setAttribute("listQuestions", listQuestions);
            req.setAttribute("listReports", listReports);
            return "/reportList.jsp";
        } catch (SQLException e) {
            generateReportListActionLog.error("Errore Interno SQL", e);
            return "/error500.jsp";
        }
    }

}
