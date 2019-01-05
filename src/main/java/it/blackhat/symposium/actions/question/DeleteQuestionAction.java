package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
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
public class DeleteQuestionAction implements Action {

    private final QuestionManager questionManager;
    private final Log deleteQuestionLog = LogFactory.getLog(DeleteQuestionAction.class);

    /**
     * Initializes a Question Manager
     */
    public DeleteQuestionAction() {
        questionManager = new QuestionModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            String idQuestion = req.getParameter("id");
            int idQuestionInt = Integer.parseInt(idQuestion);


            questionManager.deleteQuestion(idQuestionInt);

            return "/index.jsp";

        } catch (SQLException e) {
            deleteQuestionLog.error("Errore interno", e);
            return "/error500.jsp";
        }

    }
}
