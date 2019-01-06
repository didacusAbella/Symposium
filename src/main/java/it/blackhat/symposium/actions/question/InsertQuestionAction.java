package it.blackhat.symposium.actions.question;


import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.CompositeAction;
import it.blackhat.symposium.helpers.BeanValidator;
import it.blackhat.symposium.helpers.TagExtractor;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.QuestionModel;
import it.blackhat.symposium.models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Describes the insert question action by the user
 *
 * @author Gozzetto
 */
public class InsertQuestionAction extends CompositeAction {
    private final Log insertQustionLog = LogFactory.getLog(InsertQuestionAction.class);
    private final QuestionManager questionManager;


    /**
     * Create a new insert action
     *
     * @param actions other actions to execute
     */
    public InsertQuestionAction(Action... actions) {
        super(actions);
        this.questionManager = new QuestionModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            Question newQuestion = new QuestionModel();
            BeanUtils.populate(newQuestion, req.getParameterMap());
            newQuestion.setCreationDate(new Date(Calendar.getInstance().getTime().getTime()));
            newQuestion.setLastUpdate(new Date(Calendar.getInstance().getTime().getTime()));
            UserModel currentUser = (UserModel) req.getSession().getAttribute("user");
            newQuestion.setUserFk(currentUser.getEmail());
            if (BeanValidator.validateBean(newQuestion)) {
                int idQuestion = this.questionManager.insertQuestion(newQuestion);
                super.execute(req, res);
                String[] tagList = TagExtractor.extractTag(req);
                for (String tag : tagList) {
                    this.questionManager.insertQuestionTag(idQuestion, tag);
                }
                return "/index.jsp";
            } else {
                return "/error400.jsp";
            }
        } catch (IllegalAccessException e) {
            this.insertQustionLog.error("Accesso Illegale", e);
            return "/error500.jsp";
        } catch (InvocationTargetException e) {
            this.insertQustionLog.error("Invocazione metodo sbagliata", e);
            return "/error500.jsp";
        } catch (SQLException e) {
            this.insertQustionLog.error("Errore interno", e);
            return "/error500.jsp";
        }
    }
}
