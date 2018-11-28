package it.blackhat.symposium.actions.admin;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.AdminManager;
import it.blackhat.symposium.managers.AdminModelManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author didacus
 */
public class SigninAdminAction implements Action {
  
  private final AdminManager adminManager = new AdminModelManager();

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    return "";
  }
  
  
}
