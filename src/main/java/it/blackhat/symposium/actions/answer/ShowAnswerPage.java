package it.blackhat.symposium.actions.answer;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.managers.TagManager;
import it.blackhat.symposium.managers.TagModelManager;
import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Tag;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author SymposiumGroup
 */
public class ShowAnswerPage implements Action {

    private QuestionManager questionManager;
    private TagManager tagManager;
    private final Log showAnswerPageLog = LogFactory.getLog(ShowAnswerPage.class);

    /**
     * Create an action that show the answer page
     */
    public ShowAnswerPage(DataSource ds) {
        super();
        this.questionManager = new QuestionModelManager(ds);
        this.tagManager = new TagModelManager(ds);
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            int questionId = Integer.parseInt(req.getParameter("questionId"));
            Optional<Question> question = this.questionManager.findQuestion(questionId);
            if (question.isPresent()) {
                List<Tag> tagList = this.tagManager.retrieveQuestionTags(questionId);
                req.setAttribute("question", question.get());
                req.setAttribute("tags", tagList);
                return "/newAnswer.jsp";
            } else {
                return "/error500.jsp";
            }
        } catch (SQLException ex) {
            this.showAnswerPageLog.error("Errore Interno", ex);
            return "/error500.jsp";
        }
    }

}
