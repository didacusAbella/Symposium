/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.blackhat.symposium.actions.answer;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.AnswerManager;
import it.blackhat.symposium.managers.AnswerModelManager;
import it.blackhat.symposium.models.Answer;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Action for show all answers
 * @author didacus
 */
public class ShowAnswers implements Action {
    
    private final Log showAnswerLog = LogFactory.getLog(ShowAnswers.class);
    private AnswerManager manager;

    public ShowAnswers() {
        super();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            this.manager = new AnswerModelManager();
            List<Answer> answers = manager.retrieveAllQuestionAnswers();
            req.setAttribute("answers", answers);
            return "/allAnswers.jsp";
        } catch (SQLException ex) {
            showAnswerLog.error("Errore Interno", ex);
            return "/error500.jsp";
        }
    }
    
}
