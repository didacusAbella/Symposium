package it.blackhat.symposium.actions.tag;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.TagManager;
import it.blackhat.symposium.managers.TagModelManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *Changes a tag from the database
 * @author Giuseppe Madonna
 */
public class ChangeTagAction implements Action {

    private TagManager tags ;
    private final Log changeTagLog = LogFactory.getLog(ChangeTagAction.class);
    /**
     * Class Constructor
     */
    public ChangeTagAction() {
        super();
    }
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        
        try {
            this.tags = new TagModelManager();
            String tagName = req.getParameter("tagName");
            String questionIdentificativo = req.getParameter("questionId");
            int questionId = Integer.parseInt(questionIdentificativo);
            String tagIdentificativo = req.getParameter("tagId");
            int tagId = Integer.parseInt(tagIdentificativo); 

            tags.updateTag(tagName, questionId, tagId);
            return "/index.jsp"; 
        }
        catch (SQLException e) {
            changeTagLog.error("Errore Interno", e);
            return "/error500.jsp";
        }
    } 
}
