package it.blackhat.symposium.controllers;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.user.UserActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The class handles requests for actions concerning the user
 *
 */
@WebServlet(name = "UserController",
        urlPatterns = {"/user/UserController", "/admin/UserController"})
public class UserController extends DispatcherController {

  private ActionFactory userFactory;

  @Override
  public void init() throws ServletException {
    super.init();
    this.userFactory = new UserActionFactory(this.ds);
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
