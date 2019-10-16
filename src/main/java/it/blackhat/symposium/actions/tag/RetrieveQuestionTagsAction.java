package it.blackhat.symposium.actions.tag;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.TagManager;
import it.blackhat.symposium.managers.TagModelManager;
import it.blackhat.symposium.models.Tag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

/**
 * This action finds all tags of a question
 */
public class RetrieveQuestionTagsAction implements Action {

  private final TagManager tagManager;
  private final Log retrieveQuestionTagsLog = LogFactory.getLog(RetrieveQuestionTagsAction.class);

  /**
   * Create the action
   * @param ds the datasource object
   */
  public RetrieveQuestionTagsAction(DataSource ds) {
    super();
    this.tagManager = new TagModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    try {
      String questionId = req.getParameter("questionId");
      int questionIdInt = Integer.parseInt(questionId);
      List<Tag> tags = tagManager.retrieveQuestionTags(questionIdInt);
      req.setAttribute("tags", tags);
      req.setAttribute("questionId", questionIdInt);
      return "/editTag.jsp";
    } catch (SQLException e) {
      retrieveQuestionTagsLog.error("Errore interno", e);
      return "/error500.jsp";
    }
  }
}
