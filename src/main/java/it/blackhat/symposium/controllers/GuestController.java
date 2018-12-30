package it.blackhat.symposium.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.guest.GuestActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;

/**
 * Servlet implementation class GuestController
 */
@WebServlet("/GuestController")
public class GuestController extends DispatcherController {
	private static final long serialVersionUID = 1L;
	private GuestActionFactory gaf;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.gaf = new GuestActionFactory();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuestController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException, InvalidActionException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		Action guestAction = this.gaf.createAction(action);
		String page = guestAction.execute(request, response);
		this.dispatch(request, response, page);

	}

}
