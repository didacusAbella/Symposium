package it.blackhat.symposium.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Avella
 */
public interface Action {

    /**
     * Execute the Action based on http request and response
     * @param req the request
     * @param res the response
     * @return the jsp page to redirect the user
     */
    String execute(HttpServletRequest req, HttpServletResponse res);
}
