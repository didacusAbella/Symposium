package it.blackhat.symposium.actions.answer;


import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.helpers.BeanValidator;
import it.blackhat.symposium.managers.AnswerManager;
import it.blackhat.symposium.managers.AnswerModelManager;
import it.blackhat.symposium.models.Answer;
import it.blackhat.symposium.models.AnswerModel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;


/**
 * Describes the insert answer action by the user
 *
 * @author 2Deimos
 * @author Gozzetto
 */
public class InsertAnswerAction implements Action {
    private final AnswerManager answerManager;
    private final Log addAnswerLog = LogFactory.getLog(InsertAnswerAction.class);

    /**
     * Initializes a Answer Manager
     */
    public InsertAnswerAction() {
        answerManager = new AnswerModelManager();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            Answer answer = new AnswerModel();
            BeanUtils.populate(answer, req.getParameterMap());
            if (BeanValidator.validateBean(answer)) {
                answerManager.insertAnswer(answer);
                return "/index.jsp";
            } else {
                return "/error400.jsp";
            }
        } catch (IllegalAccessException e) {
            addAnswerLog.error("Accesso illegale", e);
            return "/error500.jsp";
        } catch (InvocationTargetException e) {
            addAnswerLog.error("Errore di invocazione metodo", e);
            return "/error500.jsp";
        } catch (SQLException e) {
            addAnswerLog.error("Errore interno", e);
        }
        return "/error500.jsp";
    }
}
