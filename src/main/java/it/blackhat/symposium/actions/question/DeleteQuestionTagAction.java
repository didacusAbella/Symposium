package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * This action deletes all tags of a question
 */
public class DeleteQuestionTagAction implements Action {

  private final QuestionManager questionManager;
  private final Log deleteQuestionLog = LogFactory.getLog(DeleteQuestionAction.class);

  /**
   * Create the action
   * @param ds the dataspurce object
   */
  public DeleteQuestionTagAction(DataSource ds) {
    super();
    this.questionManager = new QuestionModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    try {
      int idQuestion = Integer.parseInt(req.getParameter("questionId"));
      questionManager.deleteQuestionTag(idQuestion);
      return "/index.jsp";

    } catch (SQLException e) {
      deleteQuestionLog.error("Errore interno", e);
      return "/error500.jsp";
    }

  }
}
