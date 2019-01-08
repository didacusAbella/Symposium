package it.blackhat.symposium.actions.tag;


import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.TagManager;
import it.blackhat.symposium.managers.TagModelManager;
import it.blackhat.symposium.models.Tag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;


/**
 * Describes the insert answer action by the user
 *
 * @author 2Deimos
 */
public class RetrieveQuestionTagsAction implements Action {
    private TagManager tagManager;
    private final Log retrieveQuestionTagsLog = LogFactory.getLog(RetrieveQuestionTagsAction.class);

    /**
     * Initializes a Tag Manager
     */
    public RetrieveQuestionTagsAction() {
        super();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            this.tagManager = new TagModelManager();
            String questionId = req.getParameter("questionId");
            int questionIdInt = Integer.parseInt(questionId);
            List<Tag> tags = tagManager.retrieveQuestionTags(questionIdInt);
            req.setAttribute("tags", tags);
            return "#";
        } catch (SQLException e) {
            retrieveQuestionTagsLog.error("Errore interno", e);
            return "/error500.jsp";
        }
    }
}
