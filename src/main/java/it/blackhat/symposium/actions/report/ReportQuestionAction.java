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
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This action reports a question to admin
 */
public class ReportQuestionAction implements Action {

  private final QuestionManager questionManager;
  private final ReportManager reportManager;
  private final Log reportQuestionActionLog = LogFactory.getLog(ReportQuestionAction.class);

  /**
   * The constructor of the class
   * @param ds the datasource object
   */
  public ReportQuestionAction(DataSource ds) {
    super();
    this.questionManager = new QuestionModelManager(ds);
    this.reportManager = new ReportModelManager(ds);
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
