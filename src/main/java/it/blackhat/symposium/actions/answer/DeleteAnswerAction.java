/*package it.blackhat.symposium.actions.answer;

/*
import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.question.DeleteAnswerAction;
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
 * @author Angelo Maffettone
 */
/*public class DeleteAnswerAction implements Action {
    private final AnswerManager answerManager;
    private final Log deleteAnswerLog = LogFactory.getLog(DeleteAnswerAction.class);


    /**
     * Initializes a Answer Manager
     */
   /* public DeleteAnswerActionAction() {
        answerManager = new AnswerModelManager();
    }


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        String idAnswer = req.getParameter("id");
        int idAnswerInt = Integer.parseInt(idAnswer);


        answerManager.deleteAnswer(idAnswerInt);

        return "/index.jsp";

    } catch (
    SQLException e) {
        deleteAnswerLog.error("Errore interno", e);
        return "/error500.jsp";
    }

}*/
