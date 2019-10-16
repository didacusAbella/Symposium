package it.blackhat.symposium.controllers;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.stats.StatsActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Symposium Group
 */
@WebServlet(name = "StatsController",
        urlPatterns = {"/admin/StatsController"})
public class StatsController extends DispatcherController {

  private ActionFactory statsFactory;

  @Override
  public void init() throws ServletException {
    super.init();
    this.statsFactory = new StatsActionFactory(this.ds);
  }

  @Override
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, InvalidActionException {
    String action = request.getParameter("action");
    Action statsAction = this.statsFactory.createAction(action);
    String page = statsAction.execute(request, response);
    this.dispatch(request, response, page);
  }

}
