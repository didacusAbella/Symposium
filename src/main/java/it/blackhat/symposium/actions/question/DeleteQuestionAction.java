package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.CompositeAction;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * This action map the deletion of a question
 */
public class DeleteQuestionAction extends CompositeAction {

  private final QuestionManager questionManager;
  private final Log deleteQuestionLog = LogFactory.getLog(DeleteQuestionAction.class);

  /**
   * Create the action
   * @param ds the datasource object
   * @param actions the children actions
   */
  public DeleteQuestionAction(DataSource ds, Action... actions) {
    super(actions);
    this.questionManager = new QuestionModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    try {
      int idQuestion = Integer.parseInt(req.getParameter("questionId"));
      questionManager.deleteQuestion(idQuestion);
      super.execute(req, res);
      return "/index.jsp";

    } catch (SQLException e) {
      deleteQuestionLog.error("Errore interno", e);
      return "/error500.jsp";
    }

  }
}
