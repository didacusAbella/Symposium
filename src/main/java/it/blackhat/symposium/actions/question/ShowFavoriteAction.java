package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.User;
import it.blackhat.symposium.models.UserModel;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This action shows favourite questions
 */
public class ShowFavoriteAction implements Action {

  private final QuestionManager questionManager;
  private final Log showFavouriteActionLog = LogFactory.getLog(ShowQuestionAction.class);

  /**
   * Create the action
   * @param ds the datasource object
   */
  public ShowFavoriteAction(DataSource ds) {
    super();
    this.questionManager = new QuestionModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    try {
      User user = new UserModel();
      user = (User) req.getSession().getAttribute("user");
      String userEmail = user.getEmail();
      List<Question> questions = questionManager.findFavorite(userEmail);

      req.setAttribute("questions", questions);

      return "/favoriteQuestion.jsp";
    } catch (SQLException e) {
      showFavouriteActionLog.error("Errore Interno :", e);
      return "/error500.jsp";
    }
  }
}
