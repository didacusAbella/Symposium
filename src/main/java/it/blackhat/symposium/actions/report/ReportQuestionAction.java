package it.blackhat.symposium.actions.report;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.managers.ReportManager;
import it.blackhat.symposium.managers.ReportModelManager;
import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Report;
import it.blackhat.symposium.models.ReportModel;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Describes the report question action
 *
 * @author Andrea
 */
public class ReportQuestionAction implements Action {

    private final QuestionManager questionManager;
    private final ReportManager reportManager;
    private final Log reportQuestionActionLog = LogFactory.getLog(ReportQuestionAction.class);

    public ReportQuestionAction() {
        questionManager = new QuestionModelManager();
        reportManager = new ReportModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            String category = req.getParameter("category");
            String reason = req.getParameter("reason");
            int year = Calendar.getInstance().get(Calendar.YEAR);
            int questionId = Integer.parseInt(req.getParameter("questionId"));

            Optional<Question> found = questionManager.findQuestion(questionId);
            if (found.isPresent()) {
                Question question = found.get();
                Report report = new ReportModel();
                report.setCategory(category);
                report.setReason(reason);
                report.setYear(year);
                reportManager.insertReport(report, question);
                return "/index.jsp";
            } else {
                return "/error400.jsp";
            }
        } catch (SQLException e) {
            reportQuestionActionLog.error("Errore interno", e);
            return "/error500.jsp";
        }
    }

}
