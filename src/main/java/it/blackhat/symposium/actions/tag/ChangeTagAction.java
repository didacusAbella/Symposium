package it.blackhat.symposium.actions.tag;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.TagManager;
import it.blackhat.symposium.managers.TagModelManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Changes a tag from the database
 *
 * @author Giuseppe Madonna
 */
public class ChangeTagAction implements Action {

  private final TagManager tags;
  private final Log changeTagLog = LogFactory.getLog(ChangeTagAction.class);

  /**
   * Class Constructor
   */
  public ChangeTagAction(DataSource ds) {
    super();
    this.tags = new TagModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {

    try {
      String[] tagnames = req.getParameterValues("tag");
      String questionIdentificativo = req.getParameter("questionId");
      int questionId = Integer.parseInt(questionIdentificativo);
      String[] tagids = req.getParameterValues("tagId");
      for (int i = 0; i < tagids.length; i++) {
        tags.updateTag(tagnames[i], questionId, Integer.parseInt(tagids[i]));
      }
      return "/index.jsp";
    } catch (SQLException e) {
      changeTagLog.error("Errore Interno", e);
      return "/error500.jsp";
    }
  }
}
