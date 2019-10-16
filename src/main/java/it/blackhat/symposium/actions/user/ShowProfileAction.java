package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Show the profile page
 */
public class ShowProfileAction implements Action {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    return "/profile.jsp";
  }
}
