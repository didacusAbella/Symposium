package it.blackhat.symposium.actions.tag;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.helpers.TagExtractor;
import it.blackhat.symposium.managers.TagManager;
import it.blackhat.symposium.managers.TagModelManager;
import it.blackhat.symposium.models.Tag;
import it.blackhat.symposium.models.TagModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class InsertTagAction implements Action {
    private final Log insertTagLog = LogFactory.getLog(InsertTagAction.class);
    private final TagManager tagManager;


    /**
     * Create an action to insert tags
     */
    public InsertTagAction() {
        this.tagManager = new TagModelManager();
    }


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            String[] tags = TagExtractor.extractTag(req);
            for (String tag : tags) {
                Tag newTag = new TagModel();
                newTag.setName(tag);
                this.tagManager.insertTag(newTag);
            }
            return "";
        } catch (SQLException e) {
            insertTagLog.error("Errore interno", e);
            return "/error500.jsp";
        }

    }

}
