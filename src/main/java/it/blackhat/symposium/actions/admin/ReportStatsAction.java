package it.blackhat.symposium.actions.admin;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.blackhat.symposium.actions.Action;

/**
 * Generates a report of the site for the admin
 * @author Parrilli Carminantonio
 *
 */
public class ReportStatsAction implements Action {
    /**
     * The constructor of the class
     */
    ReportStatsAction() {
        
    }
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        String temp = req.getParameter("Date");
        Date dateForStats = new Date(Integer.parseInt(temp));
        
        return "/reportPage.jsp";
    }

}
