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
 * Add one question to favourites
 * @author Gozzetto
 */
public class AddFavouriteAction extends CompositeAction {
    
    private QuestionManager questionManager;
    private final Log addFavouriteActionLog = LogFactory.getLog(ShowQuestionAction.class);

    /**
     * Create a new Action for add a question to favourites
     * @param actions list of actions
     */
    public AddFavouriteAction(Action... actions) {
        super(actions);
    }
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            this.questionManager = new QuestionModelManager();
            String idQuestion = req.getParameter("questionId");
            int idQuestionInt = Integer.parseInt(idQuestion);
            String emailUser = req.getParameter("userEmail");
            if (questionManager.controlFavorite(emailUser, idQuestionInt)) {
                questionManager.addFavourite(emailUser, idQuestionInt);
                return "/user/QuestionController?action=showFavorite";
            }
            else {
                 return super.execute(req, res);
            }
        } catch (SQLException e) {
            addFavouriteActionLog.error("Errore interno", e);
            return "/error500.jsp";
        }
    }
}
