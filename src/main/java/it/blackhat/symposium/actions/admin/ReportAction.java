package it.blackhat.symposium.actions.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.blackhat.symposium.actions.Action;

/**
 * @author killer
 *
 */
public class ReportAction implements Action {
    /**
     * The constructor of the class
     */
    ReportAction() {
        
    }
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        
        return "/reportPage.jsp";
    }

}
