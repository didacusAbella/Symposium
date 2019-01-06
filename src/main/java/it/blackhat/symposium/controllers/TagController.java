package it.blackhat.symposium.controllers;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.tag.TagActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giuseppe Madonna
 */

@WebServlet(name = "TagController", 
        urlPatterns = {"/user/TagController", "/admin/TagController"})
public class TagController extends DispatcherController {

    private ActionFactory tagFactory;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.tagFactory = new TagActionFactory();
    }
    
    @Override
    public String getServletInfo(){
        return "TagController";
    }
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvalidActionException {
        String action = request.getParameter("action");
        Action tagAction = this.tagFactory.createAction(action);
        String page = tagAction.execute(request, response);
        this.dispatch(request, response, page);
    }
    
}
