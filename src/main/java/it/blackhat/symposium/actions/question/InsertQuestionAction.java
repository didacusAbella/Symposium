package it.blackhat.symposium.actions.question;


import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.CompositeAction;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.QuestionModel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Describes the insert question action by the user
 * 
 * @author Gozzetto
 */
public class InsertQuestionAction extends CompositeAction {
    private final Log insertQustionLog= LogFactory.getLog(InsertQuestionAction.class);
    private final QuestionManager questionManager;


    public InsertQuestionAction(Action... actions) {
        super(actions);
        this.questionManager = new QuestionModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            Question newQuestion = new QuestionModel();
            BeanUtils.populate(newQuestion, req.getParameterMap());
            questionManager.insertQuestion(newQuestion);
            super.execute(req,res);
            return "/index.jsp";
        }
          catch (IllegalAccessException e) {
            insertQustionLog.error("Accesso Illegale",e);
            return "/error500.jsp";
        } catch (InvocationTargetException e) {
            insertQustionLog.error("Invocazione metodo sbagliata",e);
            return "/error500.jsp";
        } catch (SQLException e) {
            insertQustionLog.error("Errore interno",e);
            return "/error500.jsp";
        }
    }
}
