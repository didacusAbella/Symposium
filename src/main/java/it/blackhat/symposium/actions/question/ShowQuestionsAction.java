package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.models.Question;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ShowQuestionsAction implements Action {
    private final QuestionManager questionManager;
    private final Log showQuestionLog = LogFactory.getLog(ShowQuestionsAction.class);

    /**
     * Initializes a Question Manager
     */
    public ShowQuestionsAction() {
        questionManager = new QuestionModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            List<Question> questions = questionManager.showLastEdit();
            req.setAttribute("questions", questions);
            return "/index.jsp";
        } catch (SQLException e) {
            showQuestionLog.error("Errore Interno", e);
            return "/error500.jsp";
        }
    }
}
