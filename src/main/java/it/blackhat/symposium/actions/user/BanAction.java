package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This action bans the user
 * @author didacus
 */
public class BanAction implements Action {

  private Date banForever;
  private Date endBanDate;
  private final UserManager userManager;
  private final Log banActionLogger = LogFactory.getLog(BanAction.class);

  /**
   * Create the action
   * @param ds the datasource object
   */
  public BanAction(DataSource ds) {
    super();
    this.userManager = new UserModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    try {
      Calendar todayDate = Calendar.getInstance();
      todayDate.add(Calendar.MONTH, 1);
      this.endBanDate = new Date(todayDate.getTimeInMillis());
      todayDate.add(Calendar.YEAR, 100);
      this.banForever = new Date(todayDate.getTimeInMillis());
      String emailUser = req.getParameter("email");
      boolean typeBan = Boolean.parseBoolean(req.getParameter("typeBan"));

      if (typeBan) {
        this.userManager.banUser(banForever, emailUser);
      } else {
        this.userManager.banUser(endBanDate, emailUser);
      }

      return "/admin/AdminController?action=showUsersAction";
    } catch (SQLException e) {
      this.banActionLogger.error("Errore Interno", e);
      return "/error500.jsp";
    }
  }
}
