package it.blackhat.symposium.controllers;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.question.*;
import it.blackhat.symposium.helpers.InvalidActionException;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The class handles requests for actions concerning the question
 *
 * @author 2Deimos
 */
@WebServlet(name = "QuestionController",
        urlPatterns = {"/user/QuestionController", "/admin/QuestionController"})
public class QuestionController extends DispatcherController {

  private ActionFactory questionFactory;

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    this.questionFactory = new QuestionActionFactory(this.ds);
  }

  @Override
  public String getServletInfo() {
    return "QuestionController";
  }

  @Override
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, InvalidActionException {
    String action = request.getParameter("action");
    Action questionAction = this.questionFactory.createAction(action);
    String page = questionAction.execute(request, response);
    this.dispatch(request, response, page);
  }

}
