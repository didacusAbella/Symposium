
package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.CompositeAction;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.models.Question;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @author Gozzetto
 */
public class ShowQuestionAction extends CompositeAction {

    private QuestionManager questionManager;
    private Log showQuestionActionLog = LogFactory.getLog(ShowQuestionAction.class);

    /**
     * Calls a list of actions and initializes a new Question Manager
     *
     * @param actions the list of actions
     */
    public ShowQuestionAction(Action... actions) {
        super(actions);
        questionManager = new QuestionModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            super.execute(req, res);
            String questionId = req.getParameter("questionId");
            int questionIdInt = Integer.parseInt(questionId);

            Optional<Question> question = questionManager.findQuestion(questionIdInt);
            if (question.isPresent()) {
                req.setAttribute("question", question.get());
                return "/question.jsp";
            } else
                return "/error400.jsp";
        } catch (SQLException e) {
            showQuestionActionLog.error("Errore interno", e);
            return "/error500.jsp";
        }
    }


}
