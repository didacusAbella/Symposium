package it.blackhat.symposium.actions.stats;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.helpers.TagExtractor;
import it.blackhat.symposium.managers.StatsManager;
import it.blackhat.symposium.managers.StatsModelManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.time.Year;
import javax.sql.DataSource;

/**
 * This action updates the stat
 */
public class UpdateStatsAction implements Action {

  private final StatsManager statsManager;
  private final Log updateStatsLog = LogFactory.getLog(UpdateStatsAction.class);

  /**
   * Create the action
   * @param ds the datasource object
   */
  public UpdateStatsAction(DataSource ds) {
    super();
    this.statsManager = new StatsModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    try {
      String[] tagList = TagExtractor.extractTag(req);
      for (String tag : tagList) {
        this.statsManager.updateStatsTag(Year.now().getValue(), tag);
      }
      return "#";
    } catch (SQLException e) {
      updateStatsLog.error("Errore Interno", e);
      return "/error500.jsp";
    }
  }
}
