package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.CompositeAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describes the delete question action by user and admin
 * @author 2Deimos
 */
public class DeleteQuestionAction extends CompositeAction {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        return "";
    }
    
}
