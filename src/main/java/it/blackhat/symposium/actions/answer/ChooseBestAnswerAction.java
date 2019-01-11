package it.blackhat.symposium.actions.answer;


import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.AnswerManager;
import it.blackhat.symposium.managers.AnswerModelManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Describes the choose best answer action by the user
 *
 * @author 2Deimos
 */
public class ChooseBestAnswerAction implements Action {
    private AnswerManager answerManager;
    private final Log chooseBestAnswerLog = LogFactory.getLog(ChooseBestAnswerAction.class);

    /**
     * Initialize a new Answer Manager
     */
    public ChooseBestAnswerAction() {
        super();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            this.answerManager = new AnswerModelManager();
            String idAnswer = req.getParameter("id");
            int idAnswerInt = Integer.parseInt(idAnswer);
            answerManager.bestAnswer(idAnswerInt);
            return "/index.jsp";
        } catch (SQLException e) {
            chooseBestAnswerLog.error("Errore interno", e);
            return "/error500.jsp";
        }
    }
}
