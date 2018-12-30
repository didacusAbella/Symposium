package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
import it.blackhat.symposium.models.UserModel;

import java.sql.SQLException;
import java.util.Optional;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @author Parrilli Carminantonio 
 * Find a user and edits it's database values
 *
 */
@WebServlet("/EditAccount")
public class EditAccountAction implements Action {
    private UserManager user;

    EditAccountAction() {
        user = new UserModelManager();
    }

    public String execute(HttpServletRequest req, HttpServletResponse res) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            Optional<User> found = user.findUser(email, DigestUtils.sha256Hex(password));
            if(found.isPresent()) {
                
                return "index.jsp";
            }
            else {
                return "error400.jsp";
            }
        }
        catch (SQLException e) {

            return "error500.jsp";
        }
        

    }
}
