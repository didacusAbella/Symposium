package it.blackhat.symposium.controllers;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.user.UserActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The class handles requests for actions concerning the user
 * @author 2Deimos
 */

@WebServlet(name = "UserController", 
       urlPatterns = {"/user/UserController", "/admin/UserController"})
public class UserController extends DispatcherController {

    private ActionFactory userFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userFactory = new UserActionFactory();
    }

    @Override
    public String getServletInfo() {
        return "UserController";
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, InvalidActionException {
        String action = request.getParameter("action");
        Action userAction = this.userFactory.createAction(action);
        String page = userAction.execute(request, response);
        this.dispatch(request, response, page);
    }

}
