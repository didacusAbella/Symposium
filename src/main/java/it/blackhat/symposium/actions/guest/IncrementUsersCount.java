package it.blackhat.symposium.actions.guest;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.StatsModelManager;

/**The class increments the number of users in the current year on the database
 * @author Parrilli Carmiantonio
 *
 */
public class IncrementUsersCount implements Action {
    private StatsModelManager statistic;
    private Log incrementUsersCountLog;
    /**
     * The constructor of the class
     */
    IncrementUsersCount() {
        statistic = new StatsModelManager();
        incrementUsersCountLog = LogFactory.getLog(SigninAction.class);
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        
        try {
            Date today = new Date(Calendar.YEAR);
            statistic.incrementSignedUpUsers(today);
            return "";
        } catch (SQLException e) {
            incrementUsersCountLog.error("Non è stato possibile aumentare il numero di iscritti");
            return "/error500.jsp";
            
        }
        
       
    }

}
