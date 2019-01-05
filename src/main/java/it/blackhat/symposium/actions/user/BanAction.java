package it.blackhat.symposium.actions.user;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The class describes the ban of a user from an admin
 *
 * @author Parrilli Carminantonio,DDeimos
 *
 */
public class BanAction implements Action {

    private final Date banForever;
    private Date endBanDate;
    private final UserManager userManager;
    private final Log banActionLogger = LogFactory.getLog(BanAction.class);

    /**
     * The costructor of the class
     */
    public BanAction() {
        this.userManager = new UserModelManager();
        this.banForever = new Date(Long.MAX_VALUE);
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            Calendar todayDate = Calendar.getInstance();
            todayDate.add(Calendar.MONTH, 1);
            this.endBanDate = new Date(todayDate.getTimeInMillis());
            String emailUser = req.getParameter("emailChoosed");
            boolean typeBan = Boolean.parseBoolean(req.getParameter("typeBan"));
            if (typeBan) {
                this.userManager.banUser(banForever, emailUser);
            } else {
                this.userManager.banUser(endBanDate, emailUser);
            }
            return "/admin/UserController?action=showUsers";
        } catch (SQLException e) {
            this.banActionLogger.error("Errore Interno", e);
            return "/error500.jsp";
        }
    }
}
