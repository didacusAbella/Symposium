package it.blackhat.symposium.actions.answer;


import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.AnswerManager;
import it.blackhat.symposium.managers.AnswerModelManager;
import it.blackhat.symposium.models.Answer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;


/**
 * Describes the insert answer action by the user
 *
 * @author 2Deimos
 */
public class RetrieveQuestionAnswersAction implements Action {
    private final AnswerManager answerManager;
    private final Log retrieveAnswersLog = LogFactory.getLog(RetrieveQuestionAnswersAction.class);

    /**
     * Initializes a Answer Manager
     */
    public RetrieveQuestionAnswersAction() {
        answerManager = new AnswerModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            String questionId = req.getParameter("questionId");
            int questionIdInt = Integer.parseInt(questionId);
            List<Answer> answers = answerManager.retrieveQuestionAnswers(questionIdInt);

            req.setAttribute("answers", answers);
            return "#";
        } catch (SQLException e) {
            retrieveAnswersLog.error("Errore interno", e);
            return "/error500.jsp";
        }
    }
}
