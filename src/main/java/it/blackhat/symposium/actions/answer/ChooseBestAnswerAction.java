package it.blackhat.symposium.actions.answer;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.AnswerManager;
import it.blackhat.symposium.managers.AnswerModelManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * This action choose the best answer for a user's question
 */
public class ChooseBestAnswerAction implements Action {

  private final AnswerManager answerManager;
  private final Log chooseBestAnswerLog = LogFactory.getLog(ChooseBestAnswerAction.class);

  /**
   * Create the action
   * @param ds the datasource object
   */
  public ChooseBestAnswerAction(DataSource ds) {
    super();
    this.answerManager = new AnswerModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    try {

      String idAnswer = req.getParameter("id");
      int idAnswerInt = Integer.parseInt(idAnswer);
      answerManager.bestAnswer(idAnswerInt);
      return "/index.jsp";
    } catch (SQLException e) {
      chooseBestAnswerLog.error("Errore interno", e);
      return "/error500.jsp";
    }
  }
}
