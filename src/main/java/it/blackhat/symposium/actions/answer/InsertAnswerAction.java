package it.blackhat.symposium.actions.answer;


import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.helpers.BeanValidator;
import it.blackhat.symposium.managers.AnswerManager;
import it.blackhat.symposium.managers.AnswerModelManager;
import it.blackhat.symposium.models.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import javax.sql.DataSource;


/**
 * Describes the insert answer action by the user
 *
 * @author 2Deimos
 * @author Gozzetto
 */
public class InsertAnswerAction implements Action {
    private AnswerManager answerManager;
    private final Log addAnswerLog = LogFactory.getLog(InsertAnswerAction.class);

    /**
     * Initializes a Answer Manager
     */
    public InsertAnswerAction(DataSource ds) {
        super();
        this.answerManager = new AnswerModelManager(ds);
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            Answer answer = new AnswerModel();
            User user = (UserModel) req.getSession().getAttribute("user");
            int questionID = Integer.parseInt(req.getParameter("questionID"));
            answer.setUserFk(user.getEmail());
            answer.setQuestionFk(questionID);
            answer.setContent(req.getParameter("answerContent"));
            answer.setCreationDate(new Date(Calendar.getInstance().getTime().getTime()));
            System.out.println("Risposta " + answer);
            if (BeanValidator.validateBean(answer)) {
                answerManager.insertAnswer(answer);
                return "/index.jsp";
            } else {
                return "/error400.jsp";
            }
        } catch (SQLException e) {
            addAnswerLog.error("Errore interno", e);
            return "/error500.jsp";
        }
    }
}
