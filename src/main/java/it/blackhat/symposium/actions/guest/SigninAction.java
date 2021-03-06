package it.blackhat.symposium.actions.guest;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Optional;
import javax.sql.DataSource;

/**
 * This action maps the signin of a user 
 * @author didacus
 */
public class SigninAction implements Action {

  private final UserManager user;
  private final Log signinLog = LogFactory.getLog(SigninAction.class);

  /**
   * Create the action
   * @param ds the datasource
   */
  public SigninAction(DataSource ds) {
    super();
    this.user = new UserModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    try {
      String email = req.getParameter("email");
      String password = req.getParameter("password");
      password = DigestUtils.sha256Hex(password);
      Optional<User> found = user.findUser(email, password);
      if (found.isPresent()) {
        Date today = new Date(Calendar.getInstance().getTime().getTime());
        if (found.get().getBanLastDate() == null
                || today.after(found.get().getBanLastDate())) {
          HttpSession session = req.getSession();
          session.setAttribute("user", found.get());
          return "/index.jsp";
        } else {

          return "/error401.jsp";
        }
      } else {
        req.setAttribute("emailErr", "Email o password errata ");
        return "/signIn.jsp";
      }
    } catch (SQLException e) {
      signinLog.error("problemi interni", e);
      return "/error500.jsp";
    }
  }
}
