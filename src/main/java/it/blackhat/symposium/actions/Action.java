package it.blackhat.symposium.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * An Action map an end User Action or an inner action with some specific 
 * business code
 */
public interface Action {

  /**
   * Execute the Action based on http request and response
   *
   * @param req the request
   * @param res the response
   * @return the jsp page to redirect the user
   */
  String execute(HttpServletRequest req, HttpServletResponse res);
}
