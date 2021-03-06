package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.helpers.QuestionTag;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.managers.TagManager;
import it.blackhat.symposium.managers.TagModelManager;
import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Tag;
import it.blackhat.symposium.models.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 * This action shows the user's question
 */
public class ShowMyQuestion implements Action {

  private final QuestionManager questionManager;
  private final TagManager tagManager;
  private final Log showQuestionLog = LogFactory.getLog(ShowQuestionsAction.class);

  /**
   * Create the action
   * @param ds the datasource object
   */
  public ShowMyQuestion(DataSource ds) {
    super();
    this.questionManager = new QuestionModelManager(ds);
    this.tagManager = new TagModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    try {

      User user = (User) req.getSession().getAttribute("user");
      List<Question> questions = questionManager.showQuestionsByAuthor(user.getEmail());
      List<QuestionTag> questionTag = new ArrayList<>();
      for (Question question : questions) {
        List<Tag> tags = this.tagManager.retrieveQuestionTags(question.getId());
        questionTag.add(new QuestionTag(question, tags));
      }
      req.setAttribute("questionTags", questionTag);
      return "/allQuestions.jsp";
    } catch (SQLException e) {
      showQuestionLog.error("Errore Interno", e);
      return "/error500.jsp";
    }
  }
}
