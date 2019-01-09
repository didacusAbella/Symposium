package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.CompositeAction;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Describes the delete question action by user
 *
 * @author 2Deimos
 * @author Gozzetto
 */
public class DeleteQuestionAction extends CompositeAction {

    private QuestionManager questionManager;
    private final Log deleteQuestionLog = LogFactory.getLog(DeleteQuestionAction.class);

    /**
     * Create a constructor for DeleteQuestionAction
     *
     * @param actions other actions to execute
     */
    public DeleteQuestionAction(Action... actions) {
        super(actions);
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            this.questionManager = new QuestionModelManager();
            int idQuestion = Integer.parseInt(req.getParameter("questionId"));
            questionManager.deleteQuestion(idQuestion);
            super.execute(req, res);
            return "/index.jsp";

        } catch (SQLException e) {
            deleteQuestionLog.error("Errore interno", e);
            return "/error500.jsp";
        }

    }
}
