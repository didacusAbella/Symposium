package it.blackhat.symposium.controllers;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.admin.AdminActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The class handles requests for actions concerning the admin
 * @author Symposium Group
 */
@WebServlet(name = "AdminController", urlPatterns = {"/admin/AdminController"})
public class AdminController extends DispatcherController {

    private ActionFactory adminFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.adminFactory = new AdminActionFactory();
    }

    @Override
    public String getServletInfo() {
        return "AdminController";
    }

    @Override
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, InvalidActionException {
        String action = request.getParameter("action");
        Action adminAction = this.adminFactory.createAction(action);
        String page = adminAction.execute(request, response);
        this.dispatch(request, response, page);
    }

}
