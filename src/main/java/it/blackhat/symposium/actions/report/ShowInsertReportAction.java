package it.blackhat.symposium.actions.report;

import it.blackhat.symposium.actions.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowInsertReportAction implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        return "/insertReport.jsp";
    }
    
}
