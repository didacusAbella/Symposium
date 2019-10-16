package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Deletes the account of the user
 *
 * @author Parrilli Carminantonio
 */
public class DeleteAccountAction implements Action {

  private final UserManager userManager;
  private final Log deleteAccountLog = LogFactory.getLog(DeleteAccountAction.class);

  /**
   * Initialize an UserModelManager
   */
  public DeleteAccountAction(DataSource ds) {
    super();
    userManager = new UserModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    try {
      User user = (User) req.getSession().getAttribute("user");
      userManager.deleteAccount(user);
      req.getSession().removeAttribute("user");
      return "/index.jsp";
    } catch (SQLException ex) {
      deleteAccountLog.error("Errore Interno", ex);
      return "/error500.jsp";
    }
  }
}
