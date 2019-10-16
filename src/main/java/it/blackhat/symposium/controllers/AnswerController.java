package it.blackhat.symposium.controllers;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.answer.AnswerActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The class handles requests for actions concerning the answer
 * @author 2Deimos
 */
@WebServlet(name = "AnswerController", 
        urlPatterns = {"/user/AnswerController", "/admin/AnswerController"})
public class AnswerController extends DispatcherController {

    private ActionFactory answerFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.answerFactory = new AnswerActionFactory(this.ds);
    }

    @Override
    public String getServletInfo() {
        return "AnswerController";
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, InvalidActionException {
        String action = request.getParameter("action");
        Action answerAction = this.answerFactory.createAction(action);
        String page = answerAction.execute(request, response);
        this.dispatch(request, response, page);
    }

}
