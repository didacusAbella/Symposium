package it.blackhat.symposium.controllers;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.report.ReportActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author didacus
 */
public class ReportController extends DispatcherController {
    
    private ActionFactory reportFactory;

    @Override
    public void init() throws ServletException {
        super.init(); 
        this.reportFactory = new ReportActionFactory();
    }

    
    

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvalidActionException {
        String action = request.getParameter("action");
        Action questionAction = this.reportFactory.createAction(action);
        String page = questionAction.execute(request, response);
        this.dispatch(request, response, page);
    }
    
}
