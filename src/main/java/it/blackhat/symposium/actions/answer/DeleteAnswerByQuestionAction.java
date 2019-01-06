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
 * Describes the delete answer action by the user
 *
 * @author SDelPiano
 */

public class DeleteAnswerByQuestionAction implements Action {
    private final AnswerManager answerManager;
    private final Log deleteAnswerLog = LogFactory.getLog(DeleteAnswerByQuestionAction.class);

    /**
     * Initializes an Answer Manager
     */
    public DeleteAnswerByQuestionAction() {
        answerManager = new AnswerModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            String questionId = req.getParameter("id");
            int questId = Integer.parseInt(questionId);
            answerManager.removeAnswerByQuestion(questId);
            return "#";

        } catch (SQLException e) {
            deleteAnswerLog.error("Errore interno", e);
            return "/error500.jsp";
        }
    }
}
