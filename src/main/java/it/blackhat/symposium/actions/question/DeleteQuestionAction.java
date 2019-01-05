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

    private final QuestionManager questionManager;
    private final Log deleteQuestionLog = LogFactory.getLog(DeleteQuestionAction.class);

    /**
     * Create a constructor for DeleteQuestionAction
     *
     * @param actions
     */
    public DeleteQuestionAction(Action... actions) {
        super(actions);
        this.questionManager = new QuestionModelManager();
    }

    /**
     * Initializes a Question Manager
     */


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            String idQuestion = req.getParameter("id");
            int idQuestionInt = Integer.parseInt(idQuestion);
            questionManager.deleteQuestion(idQuestionInt);
            super.execute(req, res);
            return "/index.jsp";

        } catch (SQLException e) {
            deleteQuestionLog.error("Errore interno", e);
            return "/error500.jsp";
        }

    }
}
