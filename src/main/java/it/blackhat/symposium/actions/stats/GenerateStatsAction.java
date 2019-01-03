package it.blackhat.symposium.actions.stats;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.guest.SigninAction;
import it.blackhat.symposium.managers.StatsManager;
import it.blackhat.symposium.managers.StatsModelManager;
import it.blackhat.symposium.models.StatsModel;

/**
 * Generates a report of the site for the admin
 * 
 * @author Parrilli Carminantonio
 *
 */
public class GenerateStatsAction implements Action {
    private final StatsManager statsModelManager;
    private final Log signinLog = LogFactory.getLog(SigninAction.class);
    private StatsModel statitics;
    
    /**
     * The constructor of the class
     */
    public GenerateStatsAction() {
        statsModelManager = new StatsModelManager();
    }
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            String desideredDate = req.getParameter("Date");
            int users = statsModelManager.getNumberUsers(Integer.parseInt(desideredDate));
            int reports = statsModelManager.getNumberReports(Integer.parseInt(desideredDate));
            int bannedUsers = statsModelManager.getBannedUsers(Integer.parseInt(desideredDate));
            statitics = new StatsModel();
            statitics.setNumSigned(users);
            statitics.setTotalReports(reports);
            statitics.setYear(Integer.parseInt(desideredDate));
            req.setAttribute("stats", statitics);
            req.setAttribute("bannedUsers", bannedUsers);
            return "/dashboard.jsp";
        } catch (SQLException e) {
            signinLog.error("problemi interni SQL", e);
            return "/error500.jsp";
        }
    }
}
