package it.blackhat.symposium.actions.stats;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.guest.SigninAction;
import it.blackhat.symposium.managers.StatsManager;
import it.blackhat.symposium.managers.StatsModelManager;
import it.blackhat.symposium.managers.TagManager;
import it.blackhat.symposium.managers.TagModelManager;
import it.blackhat.symposium.models.StatsModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

/**
 * This action generates the statistics for the report
 */
public class GenerateStatsAction implements Action {

  private final StatsManager statsModelManager;
  private final Log signinLog = LogFactory.getLog(SigninAction.class);
  private StatsModel statitics;
  private final TagManager tagModelManager;

  /**
   * Create the action
   * @param ds the datasource object
   */
  public GenerateStatsAction(DataSource ds) {
    super();
    this.statsModelManager = new StatsModelManager(ds);
    this.tagModelManager = new TagModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    try {
      String desideredDate = req.getParameter("year");
      int year = Integer.parseInt(desideredDate);
      int users = statsModelManager.getNumberUsers(year);
      int reports = statsModelManager.getNumberReports(year);
      int bannedUsers = statsModelManager.getBannedUsers(year);
      Map<String, Integer> tags = tagModelManager.mostUsedTags(year);
      statitics = new StatsModel();
      statitics.setNumSigned(users);
      statitics.setTotalReports(reports);
      statitics.setYear(Integer.parseInt(desideredDate));
      req.setAttribute("stats", statitics);
      req.setAttribute("bannedUsers", bannedUsers);
      req.setAttribute("tags", tags);
      return "/stats.jsp";
    } catch (SQLException e) {
      signinLog.error("problemi interni SQL", e);
      return "/error500.jsp";
    }
  }
}
