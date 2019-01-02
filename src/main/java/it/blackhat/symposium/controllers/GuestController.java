package it.blackhat.symposium.controllers;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.guest.GuestActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class GuestController
 */
@WebServlet(name = "GuestController", urlPatterns = {"/GuestController"})
public class GuestController extends DispatcherController {
    private static final long serialVersionUID = 1L;
    private GuestActionFactory gaf;


    @Override
    public void init() throws ServletException {
        super.init();
        this.gaf = new GuestActionFactory();
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvalidActionException {
        String action = request.getParameter("action");
        Action guestAction = this.gaf.createAction(action);
        String page = guestAction.execute(request, response);
        this.dispatch(request, response, page);

    }

}
