package it.blackhat.symposium.actions.admin;


import it.blackhat.symposium.managers.AdminModelManager;
import it.blackhat.symposium.managers.UserModelManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *The class describes the ban of a user from an admin 
 * @author Parrilli Carminantonio
 *
 */
public class BanAction {
    private Date banForever;
    private Date endBanDate;
    private AdminModelManager adminModel;

    public BanAction() {
        adminModel = new AdminModelManager();
       
    }
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        Calendar todayDate = Calendar.getInstance();
        todayDate.add(Calendar.MONTH, 1);
        endBanDate = new Date(todayDate.getTimeInMillis());
        banForever = new Date(Long.MAX_VALUE);
        String emailUser = req.getParameter("emailChoosed");
        String typeBan = req.getParameter("typeBan");
        try {
            if (typeBan.equals("permanent")) 
            {
                adminModel.banUser(banForever, emailUser);
            }
            else 
            {
                adminModel.banUser(endBanDate, emailUser);
            }
        } catch (SQLException e) {
            return "/error500.jsp";
        }
        return "/adminPage.jsp";
    }
}
