package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Signout the user
 */
public class SignoutAction implements Action {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    req.getSession().removeAttribute("user");
    return "/index.jsp";
  }
}
