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
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This action generate an admin report about platform's usage
 */
public class GenerateReportListAction implements Action {

  private final ReportManager reportManager;
  private final QuestionManager questionManager;
  private final Log generateReportListActionLog
          = LogFactory.getLog(GenerateReportListAction.class);

  /**
   * Create the action
   *
   * @param ds The datasource object
   */
  public GenerateReportListAction(DataSource ds) {
    this.reportManager = new ReportModelManager(ds);
    this.questionManager = new QuestionModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
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
