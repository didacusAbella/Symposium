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
 *
 * @author Giuseppe Madonna
 */
public class ChangeTagAction implements Action{

    private final TagManager tags ;
    private final Log ChangeTagLog = LogFactory.getLog(ChangeTagAction.class);
    /**
     * Class Constructor
     */
    public ChangeTagAction(){
        tags = new TagModelManager();
    }
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        
        try{
            String tagName = req.getParameter("tagName");
            String tagIdentificativo = req.getParameter("tagId");
            int tagId = Integer.getInteger(tagIdentificativo); 
            tags.updateTag(tagName, tagId);
            return "/index.jsp"; 
        }
        catch(SQLException e){
            ChangeTagLog.error("Errore Interno", e);
            return "/error500.jsp";
        }
    } 
}
