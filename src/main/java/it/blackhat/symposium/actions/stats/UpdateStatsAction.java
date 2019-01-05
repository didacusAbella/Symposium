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

public class UpdateStatsAction implements Action {
    private final StatsManager statsManager;
    private final Log updateStatsLog = LogFactory.getLog(UpdateStatsAction.class);

    /**
     * Update the stats
     */
    public UpdateStatsAction() {
        this.statsManager = new StatsModelManager();
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
