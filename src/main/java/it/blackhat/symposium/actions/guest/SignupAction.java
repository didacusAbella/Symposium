package it.blackhat.symposium.actions.guest;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.helpers.BeanValidator;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
import it.blackhat.symposium.models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Optional;
import javax.sql.DataSource;

/**
 * This action map the signup of the user
 */
public class SignupAction implements Action {

  private final UserManager user;
  private final Log signUpLog = LogFactory.getLog(SigninAction.class);

  /**
   * Create the action
   * @param ds the datasource object
   */
  public SignupAction(DataSource ds) {
    super();
    this.user = new UserModelManager(ds);
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {

    try {
      UserModel newUser = new UserModel();
      BeanUtils.populate(newUser, req.getParameterMap());
      Optional<User> found = user.findEmail(newUser.getEmail());
      if (found.isPresent()) {
        req.setAttribute("emailErr", "Already Exist");
        return "/signUp.jsp";
      } else {
        newUser.setPassword(DigestUtils.sha256Hex(newUser.getPassword()));
        newUser.setYear(Calendar.getInstance().get(Calendar.YEAR));
        if (BeanValidator.validateBean(newUser)) {
          user.createUser(newUser);
          return "/signIn.jsp";
        } else {
          return "/error400.jsp";
        }
      }
    } catch (SQLException e) {
      signUpLog.error("problemi interni SQL", e);
      return "/error500.jsp";
    } catch (IllegalAccessException e) {
      signUpLog.error("problemi interni Accesso", e);
      return "/error500.jsp";
    } catch (InvocationTargetException e) {
      signUpLog.error("problemi interni Invocazione", e);
      return "/error500.jsp";
    }
  }
}
