package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class show editProfile page
 *
 * @author Symposium Group
 */
public class ShowEditProfileAction implements Action {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    return "/editProfile.jsp";
  }

}
