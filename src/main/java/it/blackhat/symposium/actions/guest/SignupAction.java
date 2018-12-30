package it.blackhat.symposium.actions.guest;

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

/**
 * Describes the guest's signup action
 * 
 * @author 2Deimos,Parrilli Carminantonio
 */
@WebServlet("/SignUp")
public class SignupAction implements Action {
    private UserManager user;

    public SignupAction() {
        user = new UserModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        String email = req.getParameter("email");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String Typegrad = req.getParameter("typeGrad");
        Boolean typegrad;
        if (Typegrad.equals("triennale")) {
            typegrad = false;
        } else {
            typegrad = true;
        }
        try {
            Optional<User> found = user.findUser(email, password);
            if (found.isPresent()) {
                return "error400.jsp";
            } else {
                UserModel newUser = new UserModel(username, firstname, lastname, password, email);
                newUser.setTypeGrad(typegrad);
                user.createUser(newUser);
                req.getSession(true);
                req.setAttribute("user", found);
                return "index.jsp";

            }
        } catch (SQLException e) {
            return "error500.jsp";
        }
    }
}
