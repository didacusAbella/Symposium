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
 * Add one question to favourites
 * @author Gozzetto
 */
public class AddFavouriteAction implements Action {
    
    private QuestionManager questionManager;
    private final Log addFavouriteActionLog = LogFactory.getLog(ShowQuestionAction.class);

    /**
     * Create a new Action for add a question to favourites
     */
    public AddFavouriteAction() {
        super();
    }
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            this.questionManager = new QuestionModelManager();
            String idQuestion = req.getParameter("questionId");
            int idQuestionInt = Integer.parseInt(idQuestion);
            String emailUser = req.getParameter("userEmail");
            questionManager.addFavourite(emailUser, idQuestionInt);
            return "/index.jsp";
        } catch (SQLException e) {
            addFavouriteActionLog.error("Errore interno", e);
            return "/error500.jsp";
        }
    }
}
